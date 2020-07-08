package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
public interface CombExamItemService{


    int deleteByPrimaryKey(Long id);

    int insert(CombExamItem record);

    int insertSelective(CombExamItem record);

    CombExamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CombExamItem record);

    int updateByPrimaryKey(CombExamItem record);

}
