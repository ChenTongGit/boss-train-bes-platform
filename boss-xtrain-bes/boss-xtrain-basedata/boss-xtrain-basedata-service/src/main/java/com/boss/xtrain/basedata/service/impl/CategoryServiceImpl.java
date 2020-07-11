package com.boss.xtrain.basedata.service.impl;

import com.aliyun.oss.ServiceException;
import com.boss.xtrain.basedata.dao.CategoryDao;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDeleteIds;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryQueryDTO;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.mapper.CategoryMapper;
import com.boss.xtrain.basedata.service.CategoryService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
        if(category.getParentId() != 0){
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
    public int deleteCategory(CategoryDeleteIds categoryDeleteIds) {
        List<CategoryDeleteDTO> deleteDTOS = categoryDeleteIds.getIds();
        for (CategoryDeleteDTO categoryDeleteDTO : deleteDTOS){
            Example example = new Example(Category.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", categoryDeleteDTO.getId());
            criteria.andEqualTo("version", categoryDeleteDTO.getVersion());
            categoryDao.deleteCategory(example);
        }

        return 0;
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        PojoUtils.copyProperties(categoryDTO,category);

        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", category.getId());
        criteria.andEqualTo("version", category.getVersion());

        categoryDao.updateCategory(category,example);

    }

    @Override
    public List<CategoryDTO> queryCategory(CategoryQueryDTO categoryQueryDTO) {
        return null;
    }

    @Override
    public int checkRepeatName(CategoryDTO categoryDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        if (categoryDTO.getOrganizationId() != null){
            criteria.andEqualTo("orgId", categoryDTO.getOrganizationId());
        }
        criteria.andEqualTo("name", categoryDTO.getName());
        int result = categoryDao.checkRepeatName(example);
        if (result != 0){
            result = 1;
            throw new BusinessException(BusinessError.BASE_DATA_CATEGORY_INSERT_REPEAT_ERROR);
        }
        return result;
    }
}
