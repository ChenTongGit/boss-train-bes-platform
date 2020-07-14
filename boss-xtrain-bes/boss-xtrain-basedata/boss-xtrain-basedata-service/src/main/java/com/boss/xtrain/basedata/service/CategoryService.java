package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.category.*;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryVO;
import com.boss.xtrain.common.core.http.CommonPage;

import java.util.List;

public interface CategoryService{

    int insertCategory(CategoryDTO categoryDTO);

    int deleteCategory(CategoryDeleteIdsDTO categoryDeleteIds);

    void updateCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> queryCategoryPage(CategoryQueryDTO categoryQueryDTO);

    List<CategoryDTO> queryByIdList(CategoryIdsDTO categoryIdsDTO);

    List<CategoryDTO> queryCategory(CategoryQueryDTO categoryQueryDTO);

    List<CategoryTreeDTO> queryCategoryTree(CategoryQueryDTO categoryQueryDTO);

    int checkRepeatName(CategoryDTO categoryDTO);

}
