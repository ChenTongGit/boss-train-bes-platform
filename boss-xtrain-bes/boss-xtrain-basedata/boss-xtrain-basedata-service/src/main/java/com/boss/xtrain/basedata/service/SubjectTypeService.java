package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeInsertDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface SubjectTypeService{

    int insertSubjectType(SubjectTypeInsertDTO subjectTypeInsertDTO);

    boolean deleteSubjectType(SubjectTypeDeleteDTO subjectTypeDeleteDTO);

    void updateSubjectType(SubjectTypeDTO subjectTypeDTO);

    List<SubjectTypeDTO> querySubjectType(SubjectTypeQueryDTO subjectTypeQueryDTO);

    List<SubjectTypeDTO> querySubjectTypeById(Long orgId);

    int checkRepeatName(Example example);
}
