package com.boss.xtrain.exam.dao.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerRecordMapper extends CommonMapper<AnswerRecord> {

    int insertBatch(@Param("ansList") List<AnswerRecord> ansList);
}