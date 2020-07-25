package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;

import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类型service
 * @date 2020/07/08
 */
public interface SubjectTypeService{

    /**
     * 插入题型
     * @param subjectTypeDTO
     * @return
     */
    int insertSubjectType(SubjectTypeDTO subjectTypeDTO);

    /**
     * 删除题型
     * @param subjectTypeDeleteDTO
     * @return
     */
    boolean deleteSubjectType(SubjectTypeDeleteDTO subjectTypeDeleteDTO);

    /**
     * 批量删除题型
     * @param subjectTypeDeleteIdsDTO
     * @return
     */
    boolean deleteSubjectTypes(SubjectTypeDeleteIdsDTO subjectTypeDeleteIdsDTO);

    /**
     * 更新题型
     * @param subjectTypeDTO
     */
    void updateSubjectType(SubjectTypeDTO subjectTypeDTO);

    /**
     * 查询题目类型
     * @param subjectTypeQueryDTO
     * @return
     */
    List<SubjectTypeDTO> querySubjectType(SubjectTypeQueryDTO subjectTypeQueryDTO);

    /**
     * 查询全部题型
     * @return
     */
    List<SubjectTypeDTO> queryAll();

    /**
     * 通过组织id查询题型
     * @param orgId
     * @return
     */
    List<SubjectTypeDTO> querySubjectTypeById(Long orgId);

    /**
     * 检查重命名
     * @param subjectTypeDTO
     * @return
     */
    int checkRepeatName(SubjectTypeDTO subjectTypeDTO);
}
