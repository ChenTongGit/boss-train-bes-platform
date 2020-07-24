package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.CategoryDao;
import com.boss.xtrain.basedata.mapper.CategoryMapper;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryTreeDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Repository
@Slf4j
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> queryCategory() {
        List<Category> categories = categoryMapper.selectAll();
        return PojoUtils.copyListProperties(categories,CategoryDTO::new);
    }

    @Override
    public int insertCategory(Category category) {
        category.setStatus(1);
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategory(Example example) {
        return categoryMapper.deleteByExample(example);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public Category queryCategoryById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int checkRepeatName(Example example) { return categoryMapper.selectCountByExample(example); }


    @Override
    public List<CategoryTreeDTO> getCategoryTree(Example example) {
        List<Category> categories = categoryMapper.selectByExample(example);
        return PojoUtils.copyListProperties(categories,CategoryTreeDTO::new);
    }

    @Override
    public List<CategoryDTO> queryByCondition(Example query) {
        List<Category> categories = categoryMapper.selectByExample(query);
        return PojoUtils.copyListProperties(categories,CategoryDTO::new);
    }
}
