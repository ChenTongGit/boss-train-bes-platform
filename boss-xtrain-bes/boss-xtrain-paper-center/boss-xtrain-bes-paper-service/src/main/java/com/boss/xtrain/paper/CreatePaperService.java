package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.fastcomb.CombConfigItemQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.CombExamDTO;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.standardcomb.StandardCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.xtrain.paper.vo.paperdetail.PaperVO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateVO;

import java.util.List;

/**
 * @version: V1.0
 * @author: zjh
 * @className: CreatePaperService
 * @packageName: com.boss.bes.paper.service
 * @description: 组卷Service
 * @data: 23:09 2019/12/18
 **/
public interface CreatePaperService {
    /**
     * @methodsName: queryPaperName
     * @description: 获取试卷集合
     * @param:  paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.paperdetail.PaperVO>
     * @throws:
     */
    List<PaperVO> getPaper(PaperQueryDTO paperQueryDto);
    /**
     * @methodsName: templateQueryDto
     * @description: 获取模板集合
     * @param:  templateQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatecomb.TemplateVO>
     * @throws:
     */
    List<TemplateVO> getTempalte(TemplateQueryDTO templateQueryDto);
    /**
     * @methodsName: downLoadTemplate
     * @description: 下载模板：生成试卷
     * @param:  templateCombDto
     * @return: void
     * @throws:
     */
    void downLoadTemplate(TemplateCombDTO templateCombDto);
    /**
     * @author:  zjh
     * @methodsName: addPaper
     * @description: 查询试卷名
     * @param:  combConfigItemQueryDTO
     * @return: void
     * @throws:
     */
    void addPaper(CombConfigItemQueryDTO combConfigItemQueryDTO);
    /**
     * @methodsName: addPaperByConfigItems
     * @description: 查询试卷名
     * @param:  combExamDTO
     * @return: void
     * @throws:
     */
    void addPaperByConfigItems(CombExamDTO combExamDTO);
    /**
     * @methodsName: standardCombExam
     * @description: 标准组卷
     * @param:  standardCombDTO
     * @return: void
     * @throws:
     */
    void standardCombExam(StandardCombDTO standardCombDTO);
}
