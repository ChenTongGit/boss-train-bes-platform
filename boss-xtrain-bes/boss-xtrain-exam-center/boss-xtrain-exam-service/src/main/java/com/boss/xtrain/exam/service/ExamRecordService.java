package com.boss.xtrain.exam.service;

import com.boss.xtrain.exam.pojo.dto.ExamRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;

import java.util.List;

/**
 * 考试记录业务接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/11 14:59
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamRecordService {

    /**
     * 考试记录条件查询
     * @author ChenTong
     * @param query
     * @return java.util.List<com.boss.xtrain.exam.pojo.dto.ExamRecordDTO>
     * @date 2020/7/11 15:03
     */
    List<ExamRecordDTO> queryForCondition(ExamRecordQuery query);
}
