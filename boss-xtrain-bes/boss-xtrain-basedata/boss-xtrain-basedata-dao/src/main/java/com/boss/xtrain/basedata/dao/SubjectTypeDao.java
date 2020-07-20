package com.boss.xtrain.basedata.dao;


import com.boss.xtrain.basedata.pojo.dto.subjecttype.*;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.common.core.web.dao.CommonQuery;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface SubjectTypeDao extends CommonQuery<SubjectTypeDTO,Example> {

    int insertSubjectType(SubjectType subjectType);

    int deleteSubjectType(Example example);

    int updateSubjectType(SubjectType subjectType);

    List<SubjectType> queryAll();

    int checkRepeatName(Example example);

    List<String> queryTypeNameById(Example example);


}
