package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.category.*;
import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类别service
 * @date 2020/07/08
 */
public interface CategoryService{

    /**
     * 插入题目类别
     * @param categoryDTO
     * @return
     */
    int insertCategory(CategoryDTO categoryDTO);

    /**
     * 删除题目类别
     * @param categoryDeleteIds
     * @return
     */
    int deleteCategory(CategoryDeleteIdsDTO categoryDeleteIds);

    /**
     * 查询全部题目类别
     * @return
     */
    List<CategoryDTO> queryAll();

    /**
     * 更新题目类别
     * @param categoryDTO
     */
    void updateCategory(CategoryDTO categoryDTO);

    /**
     * 查询题目类别分页
     * @param categoryQueryDTO
     * @return
     */
    List<CategoryDTO> queryCategoryPage(CategoryQueryDTO categoryQueryDTO);

    /**
     * 根据id列表查询题目类别
     * @param categoryIdsDTO
     * @return
     */
    List<CategoryDTO> queryByIdList(CategoryIdsDTO categoryIdsDTO);

    /**
     * 查询题目类别不分页
     * @param categoryQueryDTO
     * @return
     */
    List<CategoryDTO> queryCategory(CategoryQueryDTO categoryQueryDTO);

    /**
     * 查询题目类别树
     * @param categoryQueryDTO
     * @return
     */
    List<CategoryTreeDTO> queryCategoryTree(CategoryQueryDTO categoryQueryDTO);

    /**
     * 检查插入名称是否有重复
     * @param categoryDTO
     * @return
     */
    int checkRepeatName(CategoryDTO categoryDTO);

}
