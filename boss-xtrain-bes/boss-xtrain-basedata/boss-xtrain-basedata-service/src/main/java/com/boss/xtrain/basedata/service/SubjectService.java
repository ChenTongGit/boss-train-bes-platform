package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.entity.Subject;
public interface SubjectService{


    int deleteByPrimaryKey(Long id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

}
