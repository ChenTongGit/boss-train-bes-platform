package com.boss.xtrain.paper.controller;


import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.paper.BaseServiceApi;
import com.boss.xtrain.paper.CombExamApi;
import com.boss.xtrain.paper.dto.fastcomb.CombConfigItemQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.CombConfigQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.CombExamDTO;
import com.boss.xtrain.paper.dto.standardcomb.StandardCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateCombDTO;
import com.boss.xtrain.paper.vo.downloadtemplate.TemplateCombExamVO;
import com.boss.xtrain.paper.vo.fastcomb.*;

import com.boss.xtrain.paper.vo.paperdetail.PaperQueryVO;
import com.boss.xtrain.paper.vo.standardcomb.StandardCombVO;

import com.boss.xtrain.paper.vo.templatecomb.TemplateQueryVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @version: V1.0
 * @author: zjh
 * @className: CombExamController
 * @packageName: com.boss.bes.paper.controller
 * @description: 组卷页面
 * @data: 10:01 2019/12/19
 **/
@Api(tags={"组卷模块"})
@RestController
public class CombExamController extends PaperBaseController implements CombExamApi {
    @Autowired
    private BaseServiceApi baseServiceApi;

    /**
     * @param commonRequest
     * @methodsName: getPaper
     * @description: 试卷详情
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("查询试卷集合")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @Override
    public CommonResponse getPaper(@RequestBody CommonRequest<PaperQueryVO> commonRequest) {
        return CommonResponseUtil.ok("20000","成功查询试卷集合",queryPaperList(commonRequest.getBody()));
    }

    /**
     * @param commonRequest
     * @methodsName: getTemplate
     * @description: 查询模板集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("查询模板集合")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @Override
    public CommonResponse getTemplate(@RequestBody CommonRequest<TemplateQueryVO> commonRequest) {
        return  CommonResponseUtil.ok("20000","成功查询模板集合",queryTemplateList(commonRequest.getBody()));
    }

    /**
     * @param commonRequest
     * @methodsName: downLoadTemplate
     * @description: 下载模板
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiLog
    @ApiOperation("模板组卷")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @Override
    public CommonResponse downLoadTemplate(@RequestBody CommonRequest<TemplateCombDTO> commonRequest) {
        return  downloadTemplatePaper(commonRequest.getBody());
    }

    /**
     * @param commonRequest
     * @methodsName: queryCombExamConfiguration
     * @description: 向基础服务获取组卷配置信息集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("查询组卷配置集合")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @Override
    public CommonResponse queryCombExamConfiguration(@RequestBody CommonRequest<CombConfigQueryDTO> commonRequest) {
        PageInfo<CombConfigVO> pageInfo = baseServiceApi.queryCombExamConfiguration(commonRequest.getBody());
        return CommonResponseUtil.ok("20000","成功查询配置信息集合",buildPageResponse(pageInfo));
    }

    /**
     * @param commonRequest
     * @methodsName: queryConfigItemsList
     * @description: 向基础服务获取组卷配置的配置信息
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @Override
    public CommonResponse queryConfigItemsList(@RequestBody CommonRequest<CombConfigItemQueryVO> commonRequest) {
        return null;
    }

    /**
     * @param commonRequest
     * @methodsName: fastCombExam
     * @description: 查看组卷配置信息界面快速组卷
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @ApiOperation("自定义组卷配置快速组卷")
    @Override
    public CommonResponse fastCombExam(@RequestBody CommonRequest<CombExamDTO> commonRequest) {
        CombExamDTO combExamDTO = commonRequest.getBody();
        createPaperService.addPaperByConfigItems(combExamDTO);
        return CommonResponseUtil.ok("20000","快速组卷成功");
    }

    /**
     * @param commonRequest
     * @methodsName: saveCombExamItemList
     * @description: 保存配置明细集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @Override
    public CommonResponse saveCombExamItemList(@RequestBody CommonRequest<List<ConfigItemVO>> commonRequest) {
        return null;
    }

    /**
     * @param commonRequest
     * @methodsName: fastCombExamById
     * @description: 组卷配置界面的快速组卷
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @ApiOperation("组卷配置快速组卷")
    @Override
    public CommonResponse fastCombExamById(@RequestBody CommonRequest<CombConfigItemQueryDTO> commonRequest) {
        CombConfigItemQueryDTO combConfigItemQueryDTO = commonRequest.getBody();
        createPaperService.addPaper(combConfigItemQueryDTO);
        return CommonResponseUtil.ok("20000","快速组卷成功");
    }

    /**
     * @param commonRequest
     * @methodsName: standardCombExam
     * @description: 标准组卷
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @ApiOperation("标准组卷")
    @Override
    public CommonResponse standardCombExam(@RequestBody CommonRequest<StandardCombDTO> commonRequest) {
        StandardCombDTO standardCombDTO = commonRequest.getBody();
        createPaperService.standardCombExam(standardCombDTO);
        return CommonResponseUtil.ok("20000","标准组卷成功");
    }
}

