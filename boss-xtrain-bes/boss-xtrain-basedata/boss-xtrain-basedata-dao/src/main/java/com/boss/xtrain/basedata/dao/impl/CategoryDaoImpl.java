package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.CategoryDao;
import com.boss.xtrain.basedata.mapper.CategoryMapper;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> queryCategory() {
        return categoryMapper.queryCategory();
    }

    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategory(Example example) {
        return categoryMapper.deleteByExample(example);
    }

    @Override
    public int updateCategory(Category category, Example example) {
        return categoryMapper.updateByExampleSelective(category,example);
    }

    @Override
    public List<CategoryDTO> getCategory(Example example) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> categories = categoryMapper.selectByExample(example);
        PojoUtils.copyProperties(categories,categoryDTOS);
        return categoryDTOS;
    }

    @Override
    public Category queryCategoryById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int queryRepeatName(Example example) {
        return categoryMapper.selectCountByExample(example);
    }

    @Override
    public int checkRepeatName(Example example) {
        return categoryMapper.selectCountByExample(example);
    }
}
