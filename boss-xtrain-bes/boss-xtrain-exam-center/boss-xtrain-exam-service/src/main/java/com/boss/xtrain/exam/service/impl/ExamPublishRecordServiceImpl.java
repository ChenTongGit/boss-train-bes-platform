package com.boss.xtrain.exam.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.ExamPublishRecordDao;
import com.boss.xtrain.exam.dao.mapper.ExamPublishRecordMapper;
import com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamPublishRecord;
import com.boss.xtrain.exam.service.ExamPublishRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发布考试记录服务实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 22:28
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamPublishRecordServiceImpl implements ExamPublishRecordService {

    @Resource
    private IdWorker idWorker;

    @Autowired
    private ExamPublishRecordDao examPublishRecordDao;

    @Override
    public Integer publishExam(ExamPublishRecordDTO dto) {
        return null;
    }



    /**
     * 通过query查找列表 title
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     * @author ChenTong
     * @date 2020/6/22 7:05
     */
    @Override
    public List<ExamPublishRecordDTO> selectByCondition(ExamPublishRecordQuery query) {
        try {
            List<ExamPublishRecordDTO> examPublishRecordDTOS = new ArrayList<>();
            // 获取考试发布记录
            List<ExamPublishRecord> examPublishRecords = examPublishRecordDao.queryByCondition(query);
            // 获取所有发布人及其id的map
            /** uservo(name:string ,id:long)
            // TODO　List<UserVO> publishUsers = systemService.getPublishUsers();
             // 放到map中便于查询
            for (UserVO item: publishUsers) {
             map.put(String,Long)
            }
             **/
            Map<Long, String> publisherMap= new HashMap<>();

            // --------假数据 start
            publisherMap.put(11L, "张三");
            publisherMap.put(12L, "李四");
            // --------假数据 end

            for (ExamPublishRecord item:examPublishRecords) {
                ExamPublishRecordDTO examPublishRecordDTO = new ExamPublishRecordDTO();
                PojoUtils.copyProperties(item, examPublishRecordDTO);
                // 发布人名以及id转换
                examPublishRecordDTO.setPublisherName(publisherMap.get(examPublishRecordDTO.getPublisher()));
                examPublishRecordDTOS.add(examPublishRecordDTO);
            }
            return examPublishRecordDTOS;
        }catch (Exception e){
            log.error(BusinessError.EXAM_PUBLISH_RECORD_QUERY_RECORD_ERROR.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_QUERY_RECORD_ERROR, e);
        }
    }

    /**
     * 查询所有
     *
     * @return
     * @author ChenTong
     * @date 2020/7/8 9:50
     */
    @Override
    public List<ExamPublishRecordDTO> selectAll() {
        try {
            List<ExamPublishRecordDTO> examPublishRecordDTOS = new ArrayList<>();
            List<ExamPublishRecord> examPublishRecords = examPublishRecordDao.selectAll();
            for (ExamPublishRecord item:examPublishRecords) {
                ExamPublishRecordDTO examPublishRecordDTO = new ExamPublishRecordDTO();
                PojoUtils.copyProperties(item, examPublishRecordDTO);
                examPublishRecordDTOS.add(examPublishRecordDTO);
            }
            return examPublishRecordDTOS;
        }catch (Exception e){
            log.error(BusinessError.EXAM_PUBLISH_RECORD_QUERY_RECORD_ERROR.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_QUERY_RECORD_ERROR, e);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    public int delete(ExamPublishRecordDTO dto) {
        return 0;
    }

    /**
     * 批量删除数据 事务控制
     * @param dtoList dto列表
     * @return int 返回所删除的行数
     * @author ChenTong
     * @date 2020/7/4 9:09
     */
    @Transactional
    @Override
    public int delete(List<ExamPublishRecordDTO> dtoList) {
        if (null==dtoList || dtoList.isEmpty())
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_DELETE_RECORD_ERROR);
        // 处理ids 与此同时判断是否发布
        StringBuilder ids = new StringBuilder();
        // ids =" 111, 222, 2323, 3232"
        for (int i = 0; i < dtoList.size(); i++) {
            if (isPublish(dtoList.get(i)))
                throw new BusinessException(BusinessError.PUBLISH_DELETE_IS_PUBLISHED);

            // 乐观锁相关 判断是否已经被修改
            Long version = getVersionById(dtoList.get(i));
            // 判断数据版本号
            if (version.equals(dtoList.get(i).getVersion()))
                throw new BusinessException(BusinessError.VERSION_NOT_THE_SAME);
            ids.append(dtoList.get(i).getId());
            // 构造ids
            if (i != dtoList.size()-1)
                ids.append(",");
        }
        try {
            // TODO 删除考试发布记录阅卷关系表
            // 删除考试发布记录
            return examPublishRecordDao.batchDelete(ids.toString());

        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_DELETE_RECORD_ERROR, e);
        }
    }

    /**
     * 更新考试发布记录数据
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    @Transactional
    public int update(ExamPublishRecordDTO dto) {
        // 不能为空或者已经发布
        if (null == dto || isPublish(dto))
            throw new BusinessException(BusinessError.PUBLISH_DELETE_IS_PUBLISHED);
        // TODO 如果阅卷人ID更改即该数据不为空,则进行更新 1-n 不好更新 删除之后再添加
        return 0;
    }

    /**
     * 插入数据
     * @param dto 考试发布记录dto
     * @return int
     * @author ChenTong
     * @date 2020/6/22 8:18
     * @throws BusinessException 考试发布记录创建异常
     */
    @Override
    public int insert(ExamPublishRecordDTO dto) {
        try {
            ExamPublishRecord examPublishRecord = new ExamPublishRecord();
            // 数据转换
            PojoUtils.copyProperties(dto, examPublishRecord);
            // 雪花算法获取id
            examPublishRecord.setId(idWorker.nextId());
            return examPublishRecordDao.insert(examPublishRecord);
        }catch (Exception e){
            log.error(BusinessError.EXAM_PUBLISH_RECORD_INSERT_RECORD_ERROR.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_INSERT_RECORD_ERROR, e);
        }

    }
    
    /**
     * 判断该记录是否已经发布
     * @author ChenTong
     * @param dto 
     * @return boolean
     * @date 2020/7/8 23:05
     */
    private boolean isPublish(ExamPublishRecordDTO dto){
        return dto.getStatus() == 1;
    }

    /**
     * 通过记录id获取version
     * @author ChenTong
     * @param dto
     * @return java.lang.Long
     * @date 2020/7/8 23:34
     */
    private Long getVersionById(ExamPublishRecordDTO dto){
        // 从数据库中读取version
        Long version = examPublishRecordDao.getVersion(dto.getId());

        if (null == version)
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_GET_VERSION_FAIL);
        return version;

    }
}
