package com.boss.xtrain.basedata.dao;


import com.boss.xtrain.basedata.pojo.dto.subjecttype.*;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface SubjectTypeDao {

    int insertSubjectType(SubjectType subjectType);

    int deleteSubjectType(Example example);

    int updateSubjectType(SubjectType subjectType, Example example);

    List<SubjectTypeDTO> querySubjectTypeByCondition(Example example);

    SubjectType getSubjectTypes(Long id);

    int checkRepeatName(Example example);


}
