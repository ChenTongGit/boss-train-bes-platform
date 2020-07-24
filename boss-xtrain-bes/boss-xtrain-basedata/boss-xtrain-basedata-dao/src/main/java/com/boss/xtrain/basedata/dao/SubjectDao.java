package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @author guo xinrui
 * @description 题目dao
 * @date 2020/07/08
 */
public interface SubjectDao{

    /**
     * 插入题目
     * @param subject
     * @return
     */
    int insertSubject(Subject subject);

    /**
     * 删除题目
     * @param example
     * @return
     */
    int deleteSubject(Example example);

    /**
     * 批量删除题目
     * @param ids
     * @return
     */
    int deleteSubject(List<Long> ids);

    /**
     * 更新题目
     * @param subject
     * @return
     */
    int updateSubject(Subject subject);

    /**
     * 查询全部题目
     * @return
     */
    List<SubjectDTO> queryAll();

    /**
     * 查询题目信息
     * @param id
     * @return
     */
    SubjectDTO querySubjectOtherInfo(Long id);

    /**
     * 条件查询
     * @param example
     * @return
     */
    List<SubjectDTO> queryByCondition(Example example);

    /**
     * 查询字典难度列表
     * @param example
     * @return
     */
    List<DifficultDTO> queryDifficult(Example example);

    /**
     * 查询题目难度
     * @param example
     * @return
     */
    List<String> querySubjectDifficult(Example example);

    /**
     * 根据categoryname查询id
     * @param example
     * @return
     */
    List<Long> queryCategoryIdByName(Example example);

    /**
     * 根据typename查询id
     * @param example
     * @return
     */
    List<Long> queryTypeIdByName(Example example);

    /**
     * 查询题目
     * @param combExamItemDTO
     * @return
     */
    List<Subject> querySubject(CombExamItemDTO combExamItemDTO);

    /**
     * 随机组卷
     * @param combExamItemDTO
     * @param num
     * @return
     */
    List<Subject> querySubjectRandom(CombExamItemDTO combExamItemDTO,Integer num);

    /**
     * 查询组织机构下的题目
     * @param orgId
     * @param subjectTypeId
     * @return
     */
    List<SubjectDTO> queryExamSubject(Long orgId,Long subjectTypeId);

    /**
     * 根据id查询题目
     * @param id
     * @return
     */
    SubjectDTO querySubjectById(Long id);

    /**
     * 计算题目数量
     * @param example
     * @return
     */
    Integer countSubject(Example example);

    /**
     * 查重名
     * @param example
     * @return
     */
    int queryNameCount(Example example);

}
