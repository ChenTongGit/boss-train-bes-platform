package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.templatemanage.*;
import com.boss.xtrain.paper.vo.templatemanage.SubjectVO;
import com.boss.xtrain.paper.vo.templatemanage.TemplateVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: MainTainTemplateService
 * @packageName: com.boss.bes.paper.service
 * @description: 维护模板Service
 * @data: 11:56 2020/1/31
 **/
public interface MainTainTemplateService {
    /**
     * @methodsName: queryTemplate
     * @description: 获取模板集合
     * @param:  templateQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatemanage.TemplateVO>
     * @throws:
     */
    List<TemplateVO> queryTemplate(TemplateQueryDTO templateQueryDto);
    /**
     * @methodsName: querySubjectList
     * @description: 查询指定模板的题目集合
     * @param:  subjectQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatemanage.SubjectVO>
     * @throws:
     */
    List<SubjectVO> querySubjectList(SubjectQueryDTO subjectQueryDto);
    /**
     /**
     * @methodsName: deleteTemplateById
     * @description: 删除指定模板
     * @param:  deleteTemplateDto
     * @return: void
     * @throws:
     */
    void deleteTemplateById(DeleteTemplateDTO deleteTemplateDto);
    /**
     * @methodsName: deleteTemplateByList
     * @description: 批量删除模板
     * @param:  templateListDTO
     * @return: void
     * @throws:
     */
    void deleteTemplateByList(TemplateListDTO templateListDTO);
    /**
     * @methodsName: updateSubejctList
     * @description: 批量编辑指定试卷的题目集合
     * @param:  templateUpdateDto
     * @return: void
     * @throws:
     */
    void updateSubejctList(TemplateUpdateDTO templateUpdateDto);

}

