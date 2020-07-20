package com.boss.xtrain.exam.service.impl;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.redis.api.RedisUtil;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.ExamEvaluateDao;
import com.boss.xtrain.exam.dao.ExamRecordDao;
import com.boss.xtrain.exam.pojo.dto.MarkingDataItemDTO;
import com.boss.xtrain.exam.pojo.dto.MarkingDataListDto;
import com.boss.xtrain.exam.pojo.dto.MarkingSubmitDTO;
import com.boss.xtrain.exam.pojo.dto.query.MarkingQuery;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;
import com.boss.xtrain.exam.pojo.entity.ExamRecord;
import com.boss.xtrain.exam.pojo.vo.MarkingDataItemVO;
import com.boss.xtrain.exam.service.ExamEvaluateService;
import com.boss.xtrain.exam.service.PaperFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 阅卷服务业务实现类
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/14 22:34
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamEvaluateServiceImpl implements ExamEvaluateService {

    @Autowired
    private ExamEvaluateDao examEvaluateDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ExamRecordDao examRecordDao;

    @Autowired
    private PaperFeign paperFeign;

    private static final String keyPrefix = "bes:exam:evaluate:tempMarkingResultRecord:";
    /**
     * 查询该阅卷官阅卷试题
     *
     * @param query
     * @return java.util.List<com.boss.xtrain.exam.pojo.dto.MarkingDataListDto>
     * @author ChenTong
     * @date 2020/7/14 22:35
     */
    @Override
    public List<MarkingDataListDto> queryByCondition(MarkingQuery query) {
        try {

            return this.examEvaluateDao.queryByCondition(query);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_EVALUATE_QUERY_FAIL);
        }
    }

    /**
     * 回传试卷阅卷信息到redis中暂时存储
     *
     * @param markingDataItemDTOS 阅卷记录列表中间存储对每个题目的打分以及评价
     * @param examRecordId 用于redis存储当作key
     * @return void
     * @author ChenTong
     * @date 2020/7/16 15:04
     */
    @Override
    public void tempEvaluateResult(List<MarkingDataItemDTO> markingDataItemDTOS, Long examRecordId) {
        // redis的存储的key
        String key = keyPrefix+examRecordId;
        try {
            // 临时保存到redis中两天
            this.redisUtil.set(key, JSON.toJSONString(markingDataItemDTOS), 2*24L*60*60);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_EVALUATE_SET_TMP_MARKING_FAIL);
        }
    }

    /**
     * 提交阅卷信息
     *
     * @param markingSubmitDTO
     * @return boolean
     * @author ChenTong
     * @date 2020/7/16 15:07
     */
    @Override
    public boolean submitEvaluate(MarkingSubmitDTO markingSubmitDTO) {
        // 每道题目的阅卷结果列表
        List<MarkingDataItemDTO> markingDataItemDTOS = markingSubmitDTO.getList();
        List<AnswerRecord> answerRecordList = PojoUtils.copyListProperties(markingDataItemDTOS, AnswerRecord::new);
        // 更新状态位
        try {
            for (AnswerRecord entity : answerRecordList) {
                // status置一，代表已批阅
                entity.setStatus(1);
                entity.setVersion(0L);
                examEvaluateDao.updateEvaluate(entity);
            }
            ExamRecord record = new ExamRecord();
            record.setId(markingSubmitDTO.getExamRecordId());
            record.setSubjectiveSubjectScore(markingSubmitDTO.getSubjectiveSubjectScore());
            record.setScore(markingSubmitDTO.getScore());
            // 进行系统评价并保存
            record.setSystemEvaluate(this.systemEvaluate(markingSubmitDTO));
            // 设置批阅状态 2:表示已经批阅
            record.setStatus(2);
            // 获取版本号
            record.setVersion(markingSubmitDTO.getVersion());
            examRecordDao.update(record);
            // 删除redis中的数据
            this.redisUtil.delete(keyPrefix+markingSubmitDTO.getExamRecordId());
            return true;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.MARKING_ANSWER_TABLE_QUERY_FAILED);
        }

    }

    /**
     * 从redis中重新读取展示存储的考试阅卷记录
     *
     * @param examRecordId 考试记录的id
     * @return java.util.Map<java.lang.String, com.boss.xtrain.exam.pojo.dto.MarkingDataItemDTO>
     * @author ChenTong
     * @date 2020/7/16 15:08
     */
    @Override
    public Map<String, MarkingDataItemVO> getTempEvaluateResultMap(Long examRecordId) {
        Map<String, MarkingDataItemVO> map = new HashMap<>();
        /* 从redis将答案取出 */
        List<MarkingDataItemVO> markingDataItemVOS = getBackEvaluate(examRecordId);

        if(markingDataItemVOS!= null){
            for (MarkingDataItemVO vo : markingDataItemVOS) {
                map.put(Long.toString(vo.getSubjectId()), vo);
            }
        }
        // 生成map

        return map;
    }


    /**
     * 获取redis中回传的批卷记录
     *
     * @param recordId
     * @return 如果不存在，那么返回一个空的list
     */
    private List<MarkingDataItemVO> getBackEvaluate(Long recordId) {
        String key = keyPrefix+recordId;
        /* 从redis将数据取出 */
        Object backEvaluate = null;
        try {
            backEvaluate = redisUtil.get(key);
        } catch (Exception e) {
            throw new BusinessException(BusinessError.MARKING_GET_REDIS_FAILED);
        }
        List<MarkingDataItemVO> vos = new ArrayList<>();
        if (backEvaluate != null) {
            // arrayList
            vos = JSON.parseArray(backEvaluate.toString(),MarkingDataItemVO.class);
        }
        log.info("redis get: " + vos);
        return vos;
    }

    private String systemEvaluate(MarkingSubmitDTO dto){
        return "";
    }


}
