package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.CategoryDao;
import com.boss.xtrain.basedata.mapper.CategoryMapper;
import com.boss.xtrain.basedata.pojo.dto.category.*;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryVO;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.service.CategoryService;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
        }
        if (result != 0){
            throw new BusinessException(BusinessError.BASE_DATA_CATEGORY_INSERT_ERROR);
        }
        return result;
    }

    @Override
    public int deleteCategory(CategoryDeleteIdsDTO categoryDeleteIds) {
        List<Long> ids = categoryDeleteIds.getIds();
        for (Long id: ids){
            Example example = new Example(Category.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",id);
            Category category = categoryDao.queryCategoryById(id);
            criteria.andEqualTo("name",category.getName());
            criteria.andEqualTo("version", category.getVersion());
            categoryDao.deleteCategory(example);
        }
        return 0;
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
        criteria.andEqualTo("name", categoryQueryDTO.getName());
        log.info(categoryQueryDTO.getName());
        return categoryDao.queryByCondition(example);
    }

    @Override
    public List<CategoryDTO> queryByIdList(CategoryIdsDTO categoryIdsDTO) {
        Example example = new Example(Category.class);
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",categoryIdsDTO.getIds());
        criteria.andEqualTo("organizationId",categoryIdsDTO.getOrgId());
        log.info(categoryDao.queryByCondition(example).toString());
        return categoryDao.queryByCondition(example);
    }

    @Override
    public List<CategoryDTO> queryCategory(CategoryQueryDTO categoryQueryDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId", categoryQueryDTO.getOrgId());
        criteria.andEqualTo("name", categoryQueryDTO.getName());
        log.info(categoryQueryDTO.getName());

        return categoryDao.queryByCondition(example);
    }

    @Override
    public List<CategoryTreeDTO> queryCategoryTree(CategoryQueryDTO categoryQueryDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId", categoryQueryDTO.getOrgId());
        log.info(categoryQueryDTO.toString());
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
        log.info(categoryDTO.getName());
        int result = categoryDao.checkRepeatName(example);
        log.info("result:{}",result);
        if (result != 0){
            throw new BusinessException(BusinessError.BASE_DATA_CATEGORY_INSERT_REPEAT_ERROR);
        }
        return result;
    }
}
