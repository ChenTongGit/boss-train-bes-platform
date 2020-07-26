package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {
    /**
     * 模糊查询
     * @param orgId
     * @param subjectName
     * @param categoryName
     * @param typeName
     * @return
     */
    List<Subject> queryByCondition(@Param("orgId") Long orgId,@Param("name") String subjectName,
                                   @Param("categoryName") String categoryName,@Param("subjectTypeName") String typeName);

    /**
     * 根据题目类别、题型、难度获取题目
     * @param categoryId
     * @param subjectTypeId
     * @param difficulty
     * @return
     */
    List<Subject> querySubject(@Param("categoryId") Long categoryId,@Param("subjectTypeId") Long subjectTypeId,@Param("difficulty") String difficulty);

    /**
     * 随机生成题目
     * @param categoryId
     * @param subjectTypeId
     * @param difficulty
     * @param num
     * @return
     */
    List<Subject> queryByRandom(@Param("categoryId") Long categoryId,@Param("subjectTypeId") Long subjectTypeId,@Param("difficulty") String difficulty,@Param("num") Integer num);

    /**
     * 根据组织机构ID、题型获取题目
     * @param orgId
     * @param subjectTypeId
     * @return
     */
    List<Subject> getExamSubject(@Param("orgId") Long orgId,@Param("subjectTypeId") Long subjectTypeId);

    /**
     * 根据题目ID获取题目
     * @param id
     * @return
     */
    Subject getSubjectById(@Param("id") Long id);

    /**
     * 根据题目ID获取题目类别名称
     * @param subjectIds
     * @return
     */
    List<String> queryCategoryById(@Param("subjectIds")List<Long> subjectIds);

    /**
     * 获取所有的题目
     * @return
     */
    List<Subject> getSubjects();

}