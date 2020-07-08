package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
public interface CombExamConfigService{


    int deleteByPrimaryKey(Long id);

    int insert(CombExamConfig record);

    int insertSelective(CombExamConfig record);

    CombExamConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CombExamConfig record);

    int updateByPrimaryKey(CombExamConfig record);

}
