package com.boss.xtrain.exam.dao.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerRecordMapper extends CommonMapper<AnswerRecord> {

    /**
     * 批量添加考试作答
     * @param ansList
     * @return
     */
    int insertBatch(@Param("ansList") List<AnswerRecord> ansList);

    /**
     * 保存批卷记录：分数和评价
     * @param answerRecord
     * @return
     */
    int updateEvaluate(@Param("answerRecord") AnswerRecord answerRecord);
}