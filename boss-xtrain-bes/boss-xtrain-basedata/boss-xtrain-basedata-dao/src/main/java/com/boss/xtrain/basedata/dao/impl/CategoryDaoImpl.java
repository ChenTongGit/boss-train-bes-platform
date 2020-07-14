package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.CategoryDao;
import com.boss.xtrain.basedata.mapper.CategoryMapper;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryTreeDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
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
    public Category queryCategoryById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int checkRepeatName(Example example) {
        log.info("dao：{}",categoryMapper.selectCountByExample(example));
        return categoryMapper.selectCountByExample(example);
    }

    @Override
    public List<CategoryTreeDTO> getCategoryTree(Example example) {
        List<Category> categories = categoryMapper.selectByExample(example);
        List<CategoryTreeDTO> categoryTreeDTOS = PojoUtils.copyListProperties(categories,CategoryTreeDTO::new);
        return categoryTreeDTOS;
    }

    @Override
    public List<CategoryDTO> queryByCondition(Example query) {
        List<Category> categories = categoryMapper.selectByExample(query);
        List<CategoryDTO> categoryDTOS = PojoUtils.copyListProperties(categories,CategoryDTO::new);
        return categoryDTOS;
    }
}
