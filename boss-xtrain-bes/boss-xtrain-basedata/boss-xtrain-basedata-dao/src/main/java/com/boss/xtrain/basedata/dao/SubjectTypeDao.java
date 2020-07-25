package com.boss.xtrain.basedata.dao;


import com.boss.xtrain.basedata.pojo.dto.subjecttype.*;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.common.core.web.dao.CommonQuery;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类型dao
 * @date 2020/07/08
 */
public interface SubjectTypeDao extends CommonQuery<SubjectTypeDTO,Example> {

    /**
     * 插入题目类别
     * @param subjectType
     * @return
     */
    int insertSubjectType(SubjectType subjectType);

    /**
     * 删除题目类别
     * @param example
     * @return
     */
    int deleteSubjectType(Example example);

    /**
     * 更新题目类别
     * @param subjectType
     * @return
     */
    int updateSubjectType(SubjectType subjectType);

    /**
     * 查询全部题目类别
     * @return
     */
    List<SubjectType> queryAll();

    /**
     * 检查名称重复
     * @param example
     * @return
     */
    int checkRepeatName(Example example);

    /**
     * 根据id查询name
     * @param id
     * @return
     */
    SubjectType queryTypeById(Long id);

}
