package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.entity.Dictionary;
public interface DictionaryService{


    int deleteByPrimaryKey(Long id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

}
