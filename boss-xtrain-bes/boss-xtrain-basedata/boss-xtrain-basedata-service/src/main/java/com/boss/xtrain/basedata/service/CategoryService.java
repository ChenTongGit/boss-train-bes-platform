package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDeleteIds;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;

import java.util.List;

public interface CategoryService{

    int insertCategory(CategoryDTO categoryDTO);

    int deleteCategory(CategoryDeleteIds categoryDeleteIds);

    void updateCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> queryCategory(CategoryQueryDTO categoryQueryDTO);

    int checkRepeatName(CategoryDTO categoryDTO);

}
