package com.boss.xtrain.exam.dao;

import com.boss.xtrain.exam.pojo.dto.MarkingDataListDto;
import com.boss.xtrain.exam.pojo.dto.query.MarkingQuery;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;

import java.util.List;

/**
 * 阅卷管理相关数据库操作接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/12 22:36
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamEvaluateDao {
    
    /**
     * 考试阅卷id
     * @author ChenTong
     * @param query 
     * @return java.util.List<com.boss.xtrain.exam.pojo.dto.MarkingDataListDto>
     * @date 2020/7/14 22:37
     */
    List<MarkingDataListDto> queryByCondition(MarkingQuery query);

    /**
     * 保存阅卷结果 分数评价等
     * @author ChenTong
     * @param answerRecord 
     * @return int
     * @date 2020/7/15 7:17
     */
    int updateEvaluate(AnswerRecord answerRecord);
}
