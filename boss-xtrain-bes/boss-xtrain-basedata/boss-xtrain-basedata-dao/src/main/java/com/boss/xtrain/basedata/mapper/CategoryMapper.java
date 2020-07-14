package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询全部题目类别信息
     * @return
     */
    List<CategoryDTO> queryCategory();

    /**
     *
     * @param categoryQueryDTO
     * @return
     */
    List<CategoryDTO> queryCategoryByName(CategoryQueryDTO categoryQueryDTO);

}