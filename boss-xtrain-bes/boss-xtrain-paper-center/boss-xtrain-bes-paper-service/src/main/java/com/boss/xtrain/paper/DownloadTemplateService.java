package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.downloadtemplate.TemplateCombDTO;

import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.xtrain.paper.vo.downloadtemplate.TemplateVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: DownloadTemplateService
 * @packageName: com.boss.bes.paper.service
 * @description: 下载模板Service
 * @data: 10:50 2020/2/8
 **/
public interface DownloadTemplateService {
    /**
     * @methodsName: getTempalte
     * @description: 获取模板
     * @param:  templateQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.downloadtemplate.TemplateVO>
     * @throws:
     */
    List<TemplateVO> getTempalte(TemplateQueryDTO templateQueryDto);
    /**
     * @methodsName: downLoadTemplate
     * @description: 下载模板
     * @param:  templateCombDto
     * @return: void
     * @throws:
     */
    void downLoadTemplate(TemplateCombDTO templateCombDto);
}
