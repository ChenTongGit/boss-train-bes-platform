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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
     * 通过query查找列表
     *
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     * @author ChenTong
     * @date 2020/6/22 7:05
     */
    @Override
    public List<ExamPublishRecordDTO> selectByCondition(ExamPublishRecordQuery query) {
        try {
            List<ExamPublishRecordDTO> examPublishRecordDTOS = new ArrayList<>();
            List<ExamPublishRecord> examPublishRecords = examPublishRecordDao.queryByCondition(query);
            for (ExamPublishRecord item:examPublishRecords) {
                ExamPublishRecordDTO examPublishRecordDTO = new ExamPublishRecordDTO();
                PojoUtils.copyProperties(examPublishRecordDTO, item);
                examPublishRecordDTOS.add(examPublishRecordDTO);
            }
            return examPublishRecordDTOS;
        }catch (Exception e){
            log.error(BusinessError.EXAM_RECORD_INSERT_RECORD_ERROR.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_RECORD_INSERT_RECORD_ERROR, e);
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
                PojoUtils.copyProperties(examPublishRecordDTO, item);
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
     * 批量删除数据
     *
     * @param dtoList dto列表
     * @return int
     * @author ChenTong

     * @date 2020/7/4 9:09
     */
    @Override
    public int delete(List<ExamPublishRecordDTO> dtoList) {
        return 0;
    }

    /**
     * 更新用户数据
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    public int update(ExamPublishRecordDTO dto) {
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
            PojoUtils.copyProperties(dto, examPublishRecord);
            examPublishRecord.setId(idWorker.nextId());
            return examPublishRecordDao.insert(examPublishRecord);
        }catch (Exception e){
            log.error(BusinessError.EXAM_PUBLISH_RECORD_INSERT_RECORD_ERROR.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_INSERT_RECORD_ERROR, e);
        }

    }
}
