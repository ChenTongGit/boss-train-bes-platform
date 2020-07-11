package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

    /**
     * 按条件模糊查询题目
     * @param subjectQueryDTO
     * @return
     */
    List<SubjectDTO> querySubjectByCondition(SubjectQueryDTO subjectQueryDTO);
    /**
     * 查询题目类别Id按题目类别名称
     * @param categoryName
     * @return
     */
    Long queryCategoryIdByCategoryName(String categoryName);
    /**
     * 查询题目类型Id按题目类型名称
     * @param subjectTypeName
     * @return
     */
    Long querySubjectTypeIdBySubjectTypeName(String subjectTypeName);
    /**
     * 删除题目答案通过题目id
     * @param id
     * @return
     */
    int deleteSubjectAnswer(Long id);
    /**
     * 快速组卷
     * @param combExamConfigItemDTO
     * @return
     */
    List<SubjectDTO> quickMakePaper(CombExamItemDTO combExamConfigItemDTO);
    /**
     * 获取题目通过Id
     * @param id
     * @return
     */
    SubjectDTO getSubjectById(Long id);
    /**
     * 按id查询题目
     * @param subjectDeleteDTO
     * @return
     */
    SubjectDTO queryById(SubjectDeleteDTO subjectDeleteDTO);

}