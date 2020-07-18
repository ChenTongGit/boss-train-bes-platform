package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;


import com.boss.xtrain.paper.dto.templatecomb.TemplateCombDTO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateQueryVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @version: V1.0
 * @className: DownloadTemplateApi
 * @packageName: com.boss.bes.paper.api.paperapi
 * @description: 下载模板模板API
 * @data: 20:54 2020/4/1
 **/
@RequestMapping(value = "/education/bes/v1/paper/downloadTemplate")
public interface DownloadTemplateApi {
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
     * @methodsName: downLoadTemplate
     * @description: 下载模板
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/downLoadTemplate")
    public CommonResponse downLoadTemplate(@Valid CommonRequest<TemplateCombDTO> commonRequest);
}

