package com.boss.xtrain.exam.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.redis.api.RedisUtil;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.AnswerRecordDao;
import com.boss.xtrain.exam.dao.ExamRecordDao;
import com.boss.xtrain.exam.pojo.dto.AnswerDataListDTO;
import com.boss.xtrain.exam.pojo.dto.ExamRecordDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.dto.query.AnswerRecordQuery;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;
import com.boss.xtrain.exam.pojo.entity.ExamRecordListEntity;
import com.boss.xtrain.exam.pojo.vo.AnswerListDataVO;
import com.boss.xtrain.exam.pojo.vo.MarkingDataItemVO;
import com.boss.xtrain.exam.pojo.vo.PaperSubjectAnswerVO;
import com.boss.xtrain.exam.pojo.vo.test.SubjectDetailsVO;
import com.boss.xtrain.exam.service.ExamEvaluateService;
import com.boss.xtrain.exam.service.ExamRecordService;
import com.boss.xtrain.exam.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考试记录业务逻辑实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/11 15:03
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamRecordServiceImpl implements ExamRecordService {

    @Autowired
    private ExamRecordDao examRecordDao;

    @Autowired
    private AnswerRecordDao answerRecordDao;

    @Autowired
    private ExamEvaluateService evaluateService;

    @Autowired
    private ExamService examService;

    /**
     * 考试记录条件查询
     *
     * @param query
     * @return java.util.List<com.boss.xtrain.exam.pojo.dto.ExamRecordDTO>
     * @author ChenTong
     * @date 2020/7/11 15:03
     */
    @Transactional
    @Override
    public List<ExamRecordDTO> queryForCondition(ExamRecordQuery query) {
        // 从数据库读取数据
        try {
            //
            List<ExamRecordListEntity> listEntities = this.examRecordDao.queryListDataByCondition(query);
            // pojo数据转换
            return PojoUtils.copyListProperties(listEntities,ExamRecordDTO::new);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_RECORD_QUERY_FAIL);
        }

    }

    /**
     * 获取考生答卷详情
     * @author ChenTong
     * @param submitPaperQuery
 * @param queryRedis 
     * @return com.boss.xtrain.exam.pojo.vo.PaperSubjectAnswerVO
     * @date 2020/7/24 10:44
     */
    @Override
    public PaperSubjectAnswerVO getCompletePaper(SubmitExamDTO submitPaperQuery, boolean queryRedis) {

        // 1. 获取考试记录对应的答案列表
        List<AnswerDataListDTO> answerDataListDTOS = queryAnswerListByRecordId(submitPaperQuery.getExamRecordId());
        List<AnswerListDataVO> answerDataListVOS = PojoUtils.copyListProperties(answerDataListDTOS,AnswerListDataVO::new);

        // 2. 通过试卷api获取试卷，调用考试服务中的方法就好
        PaperSubjectAnswerVO paperSubjectAnswerVO = examService.getPaper(submitPaperQuery, false);

        // 3. 如果queryRedis为true，那么查询redis中的批卷记录
        Map<String, MarkingDataItemVO> backEvaluateMap = new HashMap<>();
        if (queryRedis) {
            backEvaluateMap = evaluateService.getTempEvaluateResultMap(submitPaperQuery.getExamRecordId());
        }
        // 3. 拼接成完整的试卷
        int[] visited = new int[answerDataListVOS.size()];
        // 将answerRecord中的数据整合到试卷中，拼接成完整的试卷，阅卷和批卷需要
        for (SubjectDetailsVO subjectDetailsVO : paperSubjectAnswerVO.getSubjects()) {
            for (int i = 0; i < answerDataListVOS.size(); i++) {
                AnswerListDataVO ans = answerDataListVOS.get(i);
                if (visited[i] != 1
                        && ans.getPaperSubjectId().equals(subjectDetailsVO.getPaperSubjectId())) {
                    visited[i] = 1;
                    subjectDetailsVO.setAnswerRecordId(ans.getAnswerRecordId());
                    subjectDetailsVO.setMyAnswer(ans.getMyAnswer());
                    subjectDetailsVO.setStandardAnswer(ans.getStandardAnswer());
                    subjectDetailsVO.setMyScore(ans.getScore());
                    subjectDetailsVO.setEvaluate(ans.getEvaluate());
                    // 合并redis保存的答案
                    MarkingDataItemVO markingVO = backEvaluateMap.get(Long.toString(subjectDetailsVO.getPaperSubjectId()));
                    if (markingVO != null) {
                        subjectDetailsVO.setMyScore(markingVO.getScore());
                        subjectDetailsVO.setEvaluate(markingVO.getEvaluate());
                    }
                }
            }
        }
        return paperSubjectAnswerVO;
    }


    /**
     * 根据考试记录id查询对应的所有答案记录
     *
     * @param examRecordId
     * @return
     */
    public List<AnswerDataListDTO> queryAnswerListByRecordId(Long examRecordId) {
        AnswerRecordQuery answerRecordQuery = new AnswerRecordQuery();
        answerRecordQuery.setExamRecordId(examRecordId);
        List<AnswerRecord> answerRecords = this.answerRecordDao.queryByCondition(answerRecordQuery);
        List<AnswerDataListDTO> dtos = new ArrayList<>();
        for (AnswerRecord record : answerRecords) {
            AnswerDataListDTO dto = new AnswerDataListDTO();
            BeanUtils.copyProperties(record, dto);
            dto.setAnswerRecordId(record.getId());
            dtos.add(dto);
        }
        return dtos;
    }
}
