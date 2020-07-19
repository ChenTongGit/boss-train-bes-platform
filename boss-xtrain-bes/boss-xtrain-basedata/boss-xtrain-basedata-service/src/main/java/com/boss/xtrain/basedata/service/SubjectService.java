package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.StandardCombDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import com.boss.xtrain.basedata.pojo.vo.subject.*;
import com.boss.xtrain.common.core.web.dao.CommonQuery;

import java.util.List;

public interface SubjectService {

    List<SubjectDTO> querySubjectByCondition(SubjectQueryDTO subjectQueryDTO);

    void insertSubject(SubjectUpdateDTO subjectUpdateDTO);

    void insertSubjectList(List<SubjectUpdateDTO> subjectUpdateDTOS);

    int deleteSubject(SubjectDeleteDTO subjectDeleteDTO);

    int deleteSubjectList(SubjectDeleteIdsDTO subjectDeleteIdsDTO);

    void updateSubject(SubjectUpdateDTO subjectUpdateDTO);

    List<SubjectAnswerDTO> queryAnswer(SubjectAnswerQueryDTO answerQueryDTO);

    List<DifficultDTO> queryDifficult(DifficultQueryDTO difficultQueryDTO);

    List<Long> queryCategoryIdByName(SubjectUpdateDTO subjectUpdateDTO);

    List<Long> queryTypeIdByName(SubjectUpdateDTO subjectUpdateDTO);

    List<SubjectAnswerDTO> querySubjectOtherInfo(SubjectAnswerQueryDTO answerQueryDTO);

    List<SubjectDTO> querySubject(List<CombExamItemDTO> combExamItemDTOS);

    List<SubjectDTO> querySubjectByConfig(StandardCombDTO standardCombDTO);

    List<SubjectDTO> queryExamSubject(SubjectExamQueryDTO subjectExamQueryDTO);

    SubjectExamDTO querySubjectById(List<Long> subjectIds);

    Integer querySubjectCount(CombExamItemDTO combExamItemDTO);

    void checkRepeatName(SubjectUpdateDTO subjectUpdateDTO);


}
