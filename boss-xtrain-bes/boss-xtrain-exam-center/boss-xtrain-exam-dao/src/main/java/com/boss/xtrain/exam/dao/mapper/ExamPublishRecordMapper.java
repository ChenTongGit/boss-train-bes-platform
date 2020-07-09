package com.boss.xtrain.exam.dao.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamPublishRecord;

import java.util.List;

public interface ExamPublishRecordMapper extends CommonMapper<ExamPublishRecord> {

    /**
     * 条件查询 发布时间左右 考试时间左右 title模糊查询
     * @author ChenTong
     * @param examPublishRecord 
     * @return java.util.List<com.boss.xtrain.exam.pojo.entity.ExamPublishRecord>
     * @date 2020/7/8 17:58
     */
    List<ExamPublishRecord> queryListByCondition(ExamPublishRecordQuery examPublishRecord);

    /**
     * 更新状态 发布考试 批量发布考试
     * @author ChenTong
     * @param ids
     * @return
     * @date 2020/7/8 17:59
     */
    Integer updateStatus(Long[] ids);

    Long getVersionById(Long id);


}