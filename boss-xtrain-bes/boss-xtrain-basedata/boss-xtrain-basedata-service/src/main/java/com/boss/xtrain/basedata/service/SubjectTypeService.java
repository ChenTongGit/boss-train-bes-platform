package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface SubjectTypeService{

    int insertSubjectType(SubjectTypeDTO subjectTypeDTO);

    boolean deleteSubjectType(SubjectTypeDeleteDTO subjectTypeDeleteDTO);

    boolean deleteSubjectTypes(List<SubjectTypeDeleteDTO> subjectTypeDeleteDTOS);

    void updateSubjectType(SubjectTypeDTO subjectTypeDTO);

    List<SubjectTypeDTO> querySubjectType(SubjectTypeQueryDTO subjectTypeQueryDTO);

    List<SubjectTypeDTO> querySubjectTypeById(Long orgId);

    int checkRepeatName(SubjectTypeDTO subjectTypeDTO);
}
