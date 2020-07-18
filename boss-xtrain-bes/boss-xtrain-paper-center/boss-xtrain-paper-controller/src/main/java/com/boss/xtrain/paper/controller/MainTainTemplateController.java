package com.boss.xtrain.paper.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.MainTainTemplateService;
import com.boss.xtrain.paper.MainTemplateApi;

import com.boss.xtrain.paper.dto.templatemanage.*;
import com.boss.xtrain.paper.vo.templatecomb.TemplateQueryVO;
import com.boss.xtrain.paper.vo.templatemanage.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags={"维护模板模块"})
@RestController

public class MainTainTemplateController extends PaperBaseController implements MainTemplateApi {
    @Autowired
    private MainTainTemplateService mainTainTemplateService;

    /**
     * @param commonRequest
     * @methodsName: getTemplate
     * @description: 查询模板集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("查询模板集合")
    @Override
    public CommonResponse getTemplate(@RequestBody CommonRequest<TemplateQueryVO> commonRequest) {
        return CommonResponseUtil.ok("20000","查询模板成功",queryTemplateList(commonRequest.getBody()));
    }

    /**
     * @param commonRequest
     * @methodsName: queryPaperDetail
     * @description: 查询模板的题目和答案集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("查询某个模板的题目集合")
    @Override
    public CommonResponse queryPaperDetail(@RequestBody CommonRequest<SubjectQueryDTO> commonRequest) {
        SubjectQueryDTO subjectQueryDto = commonRequest.getBody();
        List<SubjectVO> subjectVos = mainTainTemplateService.querySubjectList(subjectQueryDto);
        return CommonResponseUtil.ok("20000","查询题目集合成功",subjectVos);
    }

    /**
     * @param commonRequest
     * @methodsName: deleteOnePaper
     * @description: 删除指定模板
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("删除单个模板")
    @Override
    public CommonResponse deleteOnePaper(@RequestBody CommonRequest<DeleteTemplateDTO> commonRequest) {
        DeleteTemplateDTO deleteTemplateDto = commonRequest.getBody();
        mainTainTemplateService.deleteTemplateById(deleteTemplateDto);
        return CommonResponseUtil.ok("20000","删除模板成功!");

    }

    /**
     * @param commonRequest
     * @methodsName: deleteSomePaper
     * @description: 批量删除指定模板
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("删除模板集合")
    @Override
    public CommonResponse deleteSomePaper(@RequestBody CommonRequest<TemplateListDTO> commonRequest) {
        TemplateListDTO templateListDto = commonRequest.getBody();
        mainTainTemplateService.deleteTemplateByList(templateListDto);
        return CommonResponseUtil.ok("20000","批量删除模板成功");

    }

    /**
     * @param commonRequest
     * @methodsName: updateSubjectList
     * @description: 更新题目集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("更新模板")
    @Override
    public CommonResponse updateSubjectList(@RequestBody CommonRequest<TemplateUpdateDTO> commonRequest) {
        TemplateUpdateDTO templateUpdateDto = commonRequest.getBody();
        mainTainTemplateService.updateSubejctList(templateUpdateDto);
        return CommonResponseUtil.ok("20000","更新模板成功");

    }
}
