package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryTreeDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectQueryDTO;
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

    /**
     * 查询所有的题目类别
     * @return
     */
    List<CategoryDTO> queryCategory();

    /**
     * 插入题目类别
     * @param category
     * @return
     */
    int insertCategory(Category category);

    /**
     * 删除题目类别
     * @param example
     * @return
     */
    int deleteCategory(Example example);

    /**
     * 更新题目类别
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 根据id查询题目类别
     * @param id
     * @return
     */
    Category queryCategoryById(Long id);

    /**
     * 检查名称是否重复
     * @param example
     * @return
     */
    int checkRepeatName(Example example);

    /**
     * 获取题目类别树
     * @param example
     * @return
     */
    List<CategoryTreeDTO> getCategoryTree(Example example);
}
