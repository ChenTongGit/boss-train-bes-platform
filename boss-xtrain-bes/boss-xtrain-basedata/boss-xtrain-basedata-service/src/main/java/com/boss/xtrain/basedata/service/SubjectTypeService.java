package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.entity.SubjectType;
public interface SubjectTypeService{


    int deleteByPrimaryKey(Long id);

    int insert(SubjectType record);

    int insertSelective(SubjectType record);

    SubjectType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SubjectType record);

    int updateByPrimaryKey(SubjectType record);

}
