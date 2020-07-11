package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;

import java.util.List;

public interface SubjectDao {

    /**
     * 新增题目
     * @param subjectInsertDTO
     * @return
     */
    int insertSubject(SubjectInsertDTO subjectInsertDTO);

    /**
     * 删除题目
     * @param subjectDeleteDTO
     * @return
     */
    int deleteSubject(SubjectDeleteDTO subjectDeleteDTO);

    /**
     * 更新题目
     * @param subjectUpdateDTO
     * @return
     */
    SubjectDTO update(SubjectUpdateDTO subjectUpdateDTO);

    /**
     * 按条件查询题目列表
     * @param subjectQueryDTO
     * @return
     */
    List<SubjectDTO> queryByCondition(SubjectQueryDTO subjectQueryDTO);

    /**
     * 试卷服务请求，按配置信息快速组卷
     * @param combExamItemDTO
     * @return
     */
    List<SubjectDTO> quickMakePaper(CombExamItemDTO combExamItemDTO);
    /**
     *考试服务 通过题目ID列表获取题目描述，标准答案，分值，类型
     * @param id
     * @return
     */
    SubjectDTO getSubjectById(Long id);

}
