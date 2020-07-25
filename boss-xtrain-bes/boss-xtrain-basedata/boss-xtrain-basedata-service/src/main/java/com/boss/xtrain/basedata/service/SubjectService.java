package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.StandardCombDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;

import java.util.List;

/**
 * @author guo xinrui
 * @description 题目service
 * @date 2020/07/08
 */
public interface SubjectService {

    /**
     * 条件查询题目
     * @param subjectQueryDTO
     * @return
     */
    List<SubjectDTO> querySubjectByCondition(SubjectQueryDTO subjectQueryDTO);

    /**
     * 插入题目
     * @param subjectUpdateDTO
     */
    void insertSubject(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 批量插入题目
     * @param subjectUpdateDTOS
     */
    void insertSubjectList(List<SubjectUpdateDTO> subjectUpdateDTOS);

    /**
     * 删除题目
     * @param subjectDeleteDTO
     * @return
     */
    int deleteSubject(SubjectDeleteDTO subjectDeleteDTO);

    /**
     * 批量删除题目
     * @param subjectDeleteIdsDTO
     * @return
     */
    int deleteSubjectList(SubjectDeleteIdsDTO subjectDeleteIdsDTO);

    /**
     * 更新题目
     * @param subjectUpdateDTO
     */
    void updateSubject(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 查询对应答案
     * @param answerQueryDTO
     * @return
     */
    List<SubjectAnswerDTO> queryAnswer(SubjectAnswerQueryDTO answerQueryDTO);

    /**
     * 查询字典难度列表
     * @param difficultQueryDTO
     * @return
     */
    List<DifficultDTO> queryDifficult(DifficultQueryDTO difficultQueryDTO);

    /**
     * 根据名称查询类别id
     * @param subjectUpdateDTO
     * @return
     */
    List<Long> queryCategoryIdByName(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 根据名称查询类型id
     * @param subjectUpdateDTO
     * @return
     */
    List<Long> queryTypeIdByName(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 查询题目信息
     * @param answerQueryDTO
     * @return
     */
    List<SubjectAnswerDTO> querySubjectOtherInfo(SubjectAnswerQueryDTO answerQueryDTO);

    /**
     * 提供给组卷查询题目
     * @param combExamItemDTOS
     * @return
     */
    List<SubjectDTO> querySubject(List<CombExamItemDTO> combExamItemDTOS);

    /**
     * 通过配置查询题目
     * @param standardCombDTO
     * @return
     */
    List<SubjectDTO> querySubjectByConfig(StandardCombDTO standardCombDTO);

    /**
     * 通过题目查询类别id
     * @param subjectUpdateDTO
     * @return
     */
    List<Long> getCategoryIdBy(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 通过题目查询类型id
     * @param subjectUpdateDTO
     * @return
     */
    List<Long> getSubjectTypeIdBy(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 通过类别查询题目
     * @param subjectUpdateDTO
     * @return
     */
    List<SubjectDTO> querySubjectByCategory(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 通过题型查询题目
     * @param subjectUpdateDTO
     * @return
     */
    List<SubjectDTO> querySubjectByType(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 提供给组卷查询题目
     * @param subjectExamQueryDTO
     * @return
     */
    List<SubjectDTO> queryExamSubject(SubjectExamQueryDTO subjectExamQueryDTO);

    /**
     * 通过ids列表查询题目
     * @param subjectIds
     * @return
     */
    SubjectExamDTO querySubjectById(List<Long> subjectIds);

    /**
     * 查询存在题目数量
     * @param combExamItemDTO
     * @return
     */
    Integer querySubjectCount(CombExamItemDTO combExamItemDTO);

    /**
     * 检查题目名称重复
     * @param subjectUpdateDTO
     */
    void checkRepeatName(SubjectUpdateDTO subjectUpdateDTO);


}
