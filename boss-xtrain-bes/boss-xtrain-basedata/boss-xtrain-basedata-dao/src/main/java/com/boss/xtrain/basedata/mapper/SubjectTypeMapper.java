package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectTypeMapper extends BaseMapper<SubjectType> {

    int updateSubjectType(SubjectType subjectType);

}