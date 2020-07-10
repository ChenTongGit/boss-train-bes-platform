package com.boss.bes.paper.dao;

import com.boss.bes.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.bes.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.entity.PaperSubject;
import com.boss.bes.paper.entity.PaperSubjectAnswer;
import com.boss.bes.paper.vo.paperdetail.PaperVO;
import com.boss.bes.paper.vo.templatecomb.TemplateVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: CombPaperDao
 * @packageName: com.boss.bes.paper.dao
 * @description: 组卷DAO
 *
 **/
public interface CombPaperDao {
    /**
     *
     * @methodsName: queryPaperList
     * @description: 获取试卷集合
     * @param:  paperQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.paperdetail.PaperVO>
     * @throws:
     */
    List<PaperVO> queryPaperList(PaperQueryDTO paperQueryDTO);
    /**
     *
     * @methodsName: queryTemplateList
     * @description: 查询模板集合
     * @param:  templateQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatecomb.TemplateVO>
     * @throws:
     */
    List<TemplateVO> queryTemplateList(TemplateQueryDTO templateQueryDto);
    /**
     *
     * @methodsName: queryTemplateById
     * @description: 根据id查询模板
     * @param:  templateId
     * @return: com.boss.bes.paper.entity.Paper
     * @throws:
     */
    Paper queryTemplateById(Long templateId);
    /**
     *
     * @methodsName: downLoadTemplate
     * @description: 下载模板：生成试卷
     * @param:  tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer downLoadTemplate(Paper tPaper);
    /**
     *
     * @methodsName: downLoadTemplateTimes
     * @description: 更新模板下载次数
     * @param:  paper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer downLoadTemplateTimes(Paper paper);
    /**
     *
     * @methodsName: querySubjectById
     * @description: 根据模板ID查询其题目集合
     * @param:  paperId
     * @return: java.util.List<com.boss.bes.paper.entity.PaperSubject>
     * @throws:
     */
    List<PaperSubject> querySubjectById(Long paperId);
    /**
     *
     * @methodsName: insertSubjectList
     * @description: 插入题目集合
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertSubjectList(List<PaperSubject> list);
    /**
     *
     * @methodsName: insertAnswerList
     * @description: 插入答案集合
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertAnswerList(List<PaperSubjectAnswer> list);

    /**
     *
     * @methodsName: insertPaper
     * @description: 插入一张试卷
     * @param:  paper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertPaper(Paper paper);
    /**
     *
     * @methodsName: paperNameIsExist
     * @description: 判断试卷名是否存在
     * @param:  paperName,companyId
     * @return: boolean
     * @throws:
     */
    boolean paperNameIsExist(String paperName,Long companyId);
}

