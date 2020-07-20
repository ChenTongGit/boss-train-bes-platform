package com.boss.xtrain.exam.dao.impl;

import com.boss.xtrain.exam.dao.ExamEvaluateDao;
import com.boss.xtrain.exam.dao.mapper.AnswerRecordMapper;
import com.boss.xtrain.exam.dao.mapper.ExamRecordMapper;
import com.boss.xtrain.exam.pojo.dto.MarkingDataListDto;
import com.boss.xtrain.exam.pojo.dto.query.MarkingQuery;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 阅卷评价数据库操作接口实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/15 22:49
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Repository
public class ExamEvaluateDaoImpl implements ExamEvaluateDao{

    @Resource
    private AnswerRecordMapper answerRecordMapper;

    @Resource
    private ExamRecordMapper examRecordMapper;

    /**
     * 考试阅卷id
     *
     * @param query
     * @return java.util.List<com.boss.xtrain.exam.pojo.dto.MarkingDataListDto>
     * @author ChenTong
     * @date 2020/7/14 22:37
     */
    @Override
    public List<MarkingDataListDto> queryByCondition(MarkingQuery query) {
        return examRecordMapper.queryEvaluateByCondition(query);
    }

    /**
     * 保存阅卷结果 分数评价等
     * @param answerRecord
     * @return int
     * @author ChenTong
     * @date 2020/7/14 22:48
     */
    @Override
    public int updateEvaluate(AnswerRecord answerRecord) {
        return answerRecordMapper.updateByPrimaryKeySelective(answerRecord);
    }
}
