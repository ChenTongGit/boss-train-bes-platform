package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.CategoryDao;
import com.boss.xtrain.basedata.pojo.dto.category.*;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类别service
 * @date 2020/07/08
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public int insertCategory(CategoryDTO categoryDTO) {
        int result = checkRepeatName(categoryDTO);
        Category category = new Category();
        PojoUtils.copyProperties(categoryDTO, category);
        category.setId(idWorker.nextId());
        if(category.getParentId() != null){
            categoryDao.insertCategory(category);
        }else {
            category.setParentId(0L);
            categoryDao.insertCategory(category);
        }
        if (result != 0){
            throw new BusinessException(BusinessError.BASE_DATA_CATEGORY_INSERT_ERROR);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteCategory(CategoryDeleteIdsDTO categoryDeleteIds) {
        List<CategoryDeleteDTO> categoryDeleteDTOS = categoryDeleteIds.getIds();
        for (CategoryDeleteDTO categoryDeleteDTO : categoryDeleteDTOS) {

            Example example = new Example(Category.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", categoryDeleteDTO.getId());
            criteria.andEqualTo("version", categoryDeleteDTO.getVersion());
            categoryDao.deleteCategory(example);
        }
        return 0;
    }

    @Override
    public List<CategoryDTO> queryAll() {
        return categoryDao.queryCategory();
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        PojoUtils.copyProperties(categoryDTO,category);
        categoryDao.updateCategory(category);
    }

    @Override
    public List<CategoryDTO> queryCategoryPage(CategoryQueryDTO categoryQueryDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("updatedTime").desc();
        criteria.andEqualTo("organizationId", categoryQueryDTO.getOrgId());
        criteria.andLike("name", "%"+categoryQueryDTO.getName()+"%");
        return categoryDao.queryByCondition(example);
    }

    @Override
    public List<CategoryDTO> queryByIdList(CategoryIdsDTO categoryIdsDTO) {
        Example example = new Example(Category.class);
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",categoryIdsDTO.getIds());
        criteria.andEqualTo("organizationId",categoryIdsDTO.getOrgId());
        return categoryDao.queryByCondition(example);
    }

    @Override
    public List<CategoryDTO> queryCategory(CategoryQueryDTO categoryQueryDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId", categoryQueryDTO.getOrgId());
        criteria.andLike("name", "%"+categoryQueryDTO.getName()+"%");

        return categoryDao.queryByCondition(example);
    }

    @Override
    public List<CategoryTreeDTO> queryCategoryTree(CategoryQueryDTO categoryQueryDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId", categoryQueryDTO.getOrgId());
        return categoryDao.getCategoryTree(example);
    }

    @Override
    public int checkRepeatName(CategoryDTO categoryDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        if (categoryDTO.getOrganizationId() != null){
            criteria.andEqualTo("organizationId", categoryDTO.getOrganizationId());
        }
        criteria.andEqualTo("name", categoryDTO.getName());
        int result = categoryDao.checkRepeatName(example);
        if (result != 0){
            throw new BusinessException(BusinessError.BASE_DATA_CATEGORY_INSERT_REPEAT_ERROR);
        }
        return result;
    }
}
