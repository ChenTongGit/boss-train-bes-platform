package com.boss.bes.paper.dao;

import com.boss.bes.paper.dto.downloadtemplate.TemplateCombDTO;
import com.boss.bes.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.entity.PaperSubject;
import com.boss.bes.paper.entity.PaperSubjectAnswer;
import com.boss.bes.paper.vo.downloadtemplate.TemplateVO;

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
     * @author:  zjh
     * @methodsName: queryTemplateById
     * @description: 根据id查询模板
     * @param:  templateId
     * @return: com.boss.bes.paper.entity.Paper
     * @throws:
     */
    Paper queryTemplateById(Long templateId);
    /**
     * @author:  zjh
     * @methodsName: downLoadTemplate
     * @description: 新增模板
     * @param:  tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer downLoadTemplate(Paper tPaper);
    /**
     * @author:  zjh
     * @methodsName: downLoadTemplateTimes
     * @description: 更新模板的下载次数
     * @param:  paper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer downLoadTemplateTimes(Paper paper);
    /**
     * @author:  zjh
     * @methodsName: insertSubjectList
     * @description: 插入试卷集合
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertSubjectList(List<PaperSubject> list);
    /**
     * @author:  zjh
     * @methodsName: insertAnswerList
     * @description: 插入答案集合
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    Integer insertAnswerList(List<PaperSubjectAnswer> list);

    /**
     * @author:  zjh
     * @methodsName: paperNameIsExist
     * @description: 查询模板名是否存在
     * @param:  templateCombDto
     * @return: boolean
     * @throws:
     */
    boolean paperNameIsExist(TemplateCombDTO templateCombDto);
}

