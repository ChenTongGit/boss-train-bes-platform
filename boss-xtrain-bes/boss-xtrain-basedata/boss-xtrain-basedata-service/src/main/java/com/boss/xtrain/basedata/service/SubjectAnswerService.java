package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
public interface SubjectAnswerService{


    int deleteByPrimaryKey(Long id);

    int insert(SubjectAnswer record);

    int insertSelective(SubjectAnswer record);

    SubjectAnswer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SubjectAnswer record);

    int updateByPrimaryKey(SubjectAnswer record);

}
