package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.vo.subject.*;

import java.util.List;

public interface SubjectService{

    List<SubjectDTO> querySubjectByCondition(SubjectQueryDTO subjectQueryDTO);

    int insertSubject(SubjectInsertDTO subjectInsertDTO);

    int deleteSubject(SubjectDeleteDTO subjectDeleteDTO);

    int deleteSubjectByIds(SubjectDeleteDTO subjectDeleteDTO);

    void updateSubject(SubjectUpdateDTO subjectUpdateDTO);

    List<SubjectVO> getSubjectBydIds(SubjectVO subjectVO);

}
