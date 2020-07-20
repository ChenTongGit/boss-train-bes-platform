package com.boss.xtrain.paper.dao;

import com.boss.xtrain.paper.dto.downloadtemplate.TemplateCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.entity.SubjectAnswer;
import com.boss.xtrain.paper.vo.downloadtemplate.TemplateVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: DownloadTemplateDao
 * @packageName: com.boss.bes.paper.dao
 * @description: 下载模板DAO
 * @data: 10:52 2020/2/8
 **/
public interface DownloadTemplateDao {
    /**
     * @methodsName: queryTemplateList
     * @description: 查询模板集合
     * @param:  templateQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.downloadtemplate.TemplateVO>
     * @throws:
     */
    List<TemplateVO> queryTemplateList(TemplateQueryDTO templateQueryDTO);
    /**
     * @methodsName: queryTemplateById
     * @description: 根据id查询模板
     * @param:  templateId
     * @return: com.boss.bes.paper.entity.Paper
     * @throws:
     */
    Paper queryTemplateById(Long templateId);
    /**
     * @methodsName: downLoadTemplate
     * @description: 新增模板
     * @param:  tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer downLoadTemplate(Paper tPaper);
    /**
     * @methodsName: downLoadTemplateTimes
     * @description: 更新模板的下载次数
     * @param:  paper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer downLoadTemplateTimes(Paper paper);
    /**
     * @methodsName: insertSubjectList
     * @description: 插入试卷集合
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertSubjectList(List<PaperSubject> list);
    /**
     * @methodsName: insertAnswerList
     * @description: 插入答案集合
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertAnswerList(List<PaperSubjectAnswer> list);

    /**
     * @methodsName: paperNameIsExist
     * @description: 查询模板名是否存在
     * @param:  templateCombDto
     * @return: boolean
     * @throws:
     */
    boolean paperNameIsExist(TemplateCombDTO templateCombDto);

    List<SubjectAnswer> querySubjectAnswerList(Long paperId);
}

