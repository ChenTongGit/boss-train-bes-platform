package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface CategoryDao {

    List<CategoryDTO> queryCategory();

    int insertCategory(Category category);

    int deleteCategory(Example example);

    int updateCategory(Category category, Example example);

    List<CategoryDTO> getCategory(Example example);

    Category queryCategoryById(Long id);

    int queryRepeatName(Example example);

    int checkRepeatName(Example example);
}
