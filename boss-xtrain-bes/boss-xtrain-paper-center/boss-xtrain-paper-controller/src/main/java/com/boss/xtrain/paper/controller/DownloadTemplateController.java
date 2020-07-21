package com.boss.xtrain.paper.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.paper.DownloadTemplateApi;
import com.boss.xtrain.paper.DownloadTemplateService;


import com.boss.xtrain.paper.dto.templatecomb.TemplateCombDTO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateCombExamVO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags={"下载模板模块"})
@RestController
public class DownloadTemplateController extends PaperBaseController implements DownloadTemplateApi {
    @Autowired
    private DownloadTemplateService downloadTemplateService;

    /**
     * @param commonRequest
     * @methodsName: getTemplate
     * @description: 查询模板集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('download_template_admin')")
    @ApiOperation("查询模板集合")
    @Override
    public CommonResponse getTemplate(@RequestBody CommonRequest<TemplateQueryVO> commonRequest) {
        return CommonResponseUtil.ok("20000","查询模板成功",queryTemplateList(commonRequest.getBody()));
    }



    /**
     * @param commonRequest
     * @methodsName: downLoadTemplate
     * @description: 下载模板
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @Override
    @ApiOperation("下载模板")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('download_template_admin')")
    public CommonResponse downLoadTemplate(@RequestBody CommonRequest<TemplateCombDTO> commonRequest) {
        return downloadTemplatePaper(commonRequest.getBody());
    }
}

