package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectAnswerMapper extends BaseMapper<SubjectAnswer> {

    Integer insertBatch(@Param("subjectAnswers") List<SubjectAnswer> subjectAnswers);


}