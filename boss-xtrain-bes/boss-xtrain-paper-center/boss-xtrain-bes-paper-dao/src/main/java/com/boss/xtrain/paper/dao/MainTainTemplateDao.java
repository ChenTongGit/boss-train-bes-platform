package com.boss.xtrain.paper.dao;


import com.boss.xtrain.paper.dto.templatemanage.TemplateQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;

import com.boss.xtrain.paper.vo.templatemanage.SubjectVO;
import com.boss.xtrain.paper.vo.templatemanage.TemplateVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: MainTainTemplateDao
 * @packageName: com.boss.bes.paper.dao
 * @description: 维护模板DAO
 * @data: 11:58 2020/1/31
 **/
public interface MainTainTemplateDao {
    /**
     * @methodsName: queryTemplateList
     * @description: 获取模板集合
     * @param:  templateQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatemanage.TemplateVO>
     * @throws:
     */
    List<TemplateVO> queryTemplateList(TemplateQueryDTO templateQueryDTO);
    /**
     * @methodsName: querySubjectList
     * @description: 获取题目集合
     * @param:  paperId
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.SubjectVO>
     * @throws:
     */
    List<SubjectVO> querySubjectList(Long paperId);
    /**
     * @methodsName: deleteTemplateById
     * @description: 删除模板
     * @param:  paperId
     * @return: java.lang.Integer
     * @throws:
     */
    Integer deleteTemplateById(Long paperId);
    /**
     * @methodsName: deleteTemplateByList
     * @description: 批量删除模板
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    Integer deleteTemplateByList(List<Paper> list);
    /**
     * @methodsName: updateSubjectList
     * @description: 更新题目集合
     * @param:  tPaperSubjects
     * @return: java.lang.Integer
     * @throws:
     */
    Integer updateSubjectList(List<PaperSubject> tPaperSubjects);
    /**
     * @methodsName: queryPaperVersion
     * @description: 获取试卷version
     * @param:  paperId
     * @return: java.lang.Long
     * @throws:
     */
    Long queryPaperVersion(Long paperId);
    /**
     * @methodsName: updateVersion
     * @description: 更新试卷version
     * @param:  tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer updateVersion(Paper tPaper);
    /**
     * @methodsName: updatePaperScore
     * @description: 更新模板总分
     * @param:  paper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer updatePaperScore(Paper paper);
    /**
     * @methodsName: insertAnswerList
     * @description: 添加答案
     * @param:  tPaperSubjectAnswerList
     * @return: java.lang.Integer
     * @throws:
     */
    void insertAnswerList(List<PaperSubjectAnswer> tPaperSubjectAnswerList);
    /**
     * @methodsName: deleteSubjects
     * @description: 删除所有题目
     * @param:  paperId
     * @return: java.lang.Integer
     * @throws:
     */
    Integer deleteSubjects(Long paperId);
    /**
     * @methodsName: updateAnswerList
     * @description: 插入答案集合
     * @param:  paperSubjectAnswers
     * @return: java.lang.Integer
     * @throws:
     */
    Integer updateAnswerList(List<PaperSubjectAnswer> paperSubjectAnswers);
}

