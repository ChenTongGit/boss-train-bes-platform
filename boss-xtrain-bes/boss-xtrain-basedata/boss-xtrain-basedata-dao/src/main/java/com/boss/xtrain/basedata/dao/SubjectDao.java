package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import com.boss.xtrain.common.core.web.dao.CommonQuery;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface SubjectDao{

    int insertSubject(Subject subject);

    int deleteSubject(Example example);

    int deleteSubject(List<Long> ids);

    int updateSubject(Subject subject);

    List<SubjectDTO> queryAll();

    List<SubjectDTO> querySubjectOtherInfo(Example example);

    List<SubjectDTO> queryByCondition(Long orgId,String subjectName,String categoryName,String typeName);

    List<DifficultDTO> queryDifficult(Example example);

    List<String> querySubjectDifficult(Example example);

    List<Long> queryCategoryIdByName(Example example);

    List<Long> queryTypeIdByName(Example example);

    List<Subject> querySubject(CombExamItemDTO combExamItemDTO);

    List<Subject> querySubjectRandom(CombExamItemDTO combExamItemDTO,Integer num);

    List<SubjectDTO> queryExamSubject(Long orgId,Long subjectTypeId);

    SubjectDTO querySubjectById(Long id);

    List<String> queryCategoryById(List<Long> subjectIds);

    Integer countSubject(Example example);

    int queryNameCount(Example example);

}
