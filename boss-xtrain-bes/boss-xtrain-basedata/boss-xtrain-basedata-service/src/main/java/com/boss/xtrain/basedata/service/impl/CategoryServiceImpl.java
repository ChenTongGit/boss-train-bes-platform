package com.boss.xtrain.basedata.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.mapper.CategoryMapper;
import com.boss.xtrain.basedata.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

}
