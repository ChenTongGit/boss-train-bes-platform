package com.boss.xtrain.paper.dao;

import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.vo.paperdetail.PaperVO;
import com.boss.xtrain.paper.vo.papermanage.SubjectVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: MainTainPaperDao
 * @packageName: com.boss.bes.paper.dao
 * @description: 维护试卷DAO
 * @data: 10:41 2019/12/30
 **/
public interface MainTainPaperDao {
    /**
     * @methodsName: deletePaperById
     * @description: 删除试卷
     * @param:  paperId
     * @return: java.lang.Integer
     * @throws:
     */
    Integer deletePaperById(Long paperId);
    /**
     * @methodsName: deletePaperByList
     * @description: 根据试卷id查询题目集合
     * @param:  papers
     * @return: java.lang.Integer
     * @throws:
     */
    void deletePaperByList(List<Paper> papers);
    /**
     * @methodsName: querySubjectList
     * @description: 获取题目集合
     * @param:  paperId
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.SubjectVO>
     * @throws:
     */
    List<SubjectVO> querySubjectList(Long paperId);
    /**
     * @methodsName: updateSubjectList
     * @description: 根据试卷id查询题目集合
     * @param:  tPaperSubjects
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertSubjectList(List<PaperSubject> tPaperSubjects);
    /**
     * @methodsName: queryPaperList
     * @description: 查询试卷查询试卷
     * @param:  paperQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.PaperVO>
     * @throws:
     */
    List<PaperVO> queryPaperList(PaperQueryDTO paperQueryDTO);
    /**
     * @methodsName: queryPaperVersion
     * @description: 查询试卷version
     * @param:  paperId
     * @return: java.lang.Long
     * @throws:
     */
    Long queryPaperVersion(Long paperId);
    /**
     * @methodsName: updateVersion
     * @description: 更新version
     * @param:  tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer updatePaper(Paper tPaper);
    /**
     * @methodsName: updatePaperScore
     * @description: 更新试卷总分
     * @param:  paper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer updatePaperScore(Paper paper);
    /**
     * @methodsName: deleteSubjects
     * @description: 删除所有题目
     * @param:  paperId
     * @return: java.lang.Integer
     * @throws:
     */
    Integer deleteSubjects(Long paperId);
    /**
     * Description: 插入试卷题目集合
     * @date 12:46 2020/3/15
     * @param paperSubjectAnswers
     * @return java.lang.Integer
     */
    /**
     * @methodsName: updateAnswerList
     * @description: 插入试卷题目集合
     * @param:  paperSubjectAnswers
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertAnswerList(List<PaperSubjectAnswer> paperSubjectAnswers);
}

