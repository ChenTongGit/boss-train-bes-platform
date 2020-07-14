package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryTreeDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.common.core.web.dao.CommonQuery;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类别dao
 * @date 2020/07/08
 */
public interface CategoryDao extends CommonQuery<CategoryDTO,Example> {

    List<CategoryDTO> queryCategory();

    int insertCategory(Category category);

    int deleteCategory(Example example);

    int updateCategory(Category category, Example example);

    Category queryCategoryById(Long id);

    int checkRepeatName(Example example);

    List<CategoryTreeDTO> getCategoryTree(Example example);
}
