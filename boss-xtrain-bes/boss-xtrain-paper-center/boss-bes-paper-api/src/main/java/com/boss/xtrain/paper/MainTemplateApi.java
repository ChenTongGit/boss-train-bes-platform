package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;

import com.boss.xtrain.paper.dto.templatemanage.DeleteTemplateDTO;
import com.boss.xtrain.paper.dto.templatemanage.SubjectQueryDTO;
import com.boss.xtrain.paper.dto.templatemanage.TemplateListDTO;
import com.boss.xtrain.paper.dto.templatemanage.TemplateUpdateDTO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateQueryVO;
import com.boss.xtrain.paper.vo.templatemanage.DeleteTemplateVO;
import com.boss.xtrain.paper.vo.templatemanage.SubjectQueryVO;
import com.boss.xtrain.paper.vo.templatemanage.TemplateListVO;
import com.boss.xtrain.paper.vo.templatemanage.TemplateUpdateVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @version: V1.0
 * @className: MainTemplateApi
 * @packageName: com.boss.bes.paper.api.paperapi
 * @description: 维护模板模块API
 **/
@RequestMapping(value = "/education/bes/v1/paper/mainTainTemplate")
public interface MainTemplateApi {
    /**
     * @methodsName: getTemplate
     * @description: 查询模板集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryTemplateList")
    public CommonResponse getTemplate(@Valid CommonRequest<TemplateQueryVO> commonRequest);
    /**
     * @methodsName: queryPaperDetail
     * @description: 查询模板的题目和答案集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/querySubjectList")
    public CommonResponse queryPaperDetail(@Valid CommonRequest<SubjectQueryDTO> commonRequest);
    /**
     * @methodsName: deleteOnePaper
     * @description: 删除指定模板
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/deleteOneTemplate")
    public CommonResponse deleteOnePaper(@Valid CommonRequest<DeleteTemplateDTO> commonRequest);
    /**
     * @methodsName: deleteSomePaper
     * @description: 批量删除指定模板
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/deleteSomeTemplate")
    public CommonResponse deleteSomePaper(@Valid CommonRequest<TemplateListDTO> commonRequest);
    /**
     * @methodsName: updateSubjectList
     * @description: 更新题目集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/updateSubjectList")
    public CommonResponse updateSubjectList(@Valid CommonRequest<TemplateUpdateDTO> commonRequest);
}

