package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectTypeMapper extends BaseMapper<SubjectType> {

    int updateSubjectType(SubjectType subjectType);

}