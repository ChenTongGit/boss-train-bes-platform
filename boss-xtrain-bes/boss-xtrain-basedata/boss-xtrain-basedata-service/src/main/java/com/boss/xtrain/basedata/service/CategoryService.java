package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.entity.Category;
public interface CategoryService{


    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

}
