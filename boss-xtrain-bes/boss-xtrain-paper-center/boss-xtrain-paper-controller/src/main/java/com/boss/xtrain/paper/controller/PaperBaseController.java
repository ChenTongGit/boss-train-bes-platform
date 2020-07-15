package com.boss.xtrain.paper.controller;

import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.CreatePaperService;


import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;


import com.boss.xtrain.paper.vo.paperdetail.PaperQueryVO;
import com.boss.xtrain.paper.vo.paperdetail.PaperVO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateCombExamVO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateQueryVO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version: V1.0
 * @className: PaperBaseController
 * @packageName: com.boss.bes.paper.controller
 * @description: 维护模板页面
 **/

public class PaperBaseController extends BaseController {
    @Autowired
    protected CreatePaperService createPaperService;
    PageInfo queryTemplateList(TemplateQueryVO templateQueryVo){
        TemplateQueryDTO templateQueryDto = new TemplateQueryDTO();
        //分页
        PojoUtils.copyProperties(templateQueryVo,templateQueryDto);
        Page<Object> objects = doBeforePagination(templateQueryVo.getPageNum(),templateQueryVo.getPageSize());
        List<TemplateVO> templateList = createPaperService.getTempalte(templateQueryDto);
        PageInfo<TemplateVO> pageInfo = new PageInfo(templateList);
        pageInfo.setTotal(objects.getTotal());
        return pageInfo;
    }
    protected PageInfo queryPaperList(PaperQueryVO paperQueryVo){
        PaperQueryDTO paperQueryDto = new PaperQueryDTO();
        PojoUtils.copyProperties(paperQueryVo,paperQueryDto);
        //设置分页信息
        Page<Object> objects = doBeforePagination(paperQueryVo.getPageNum(),paperQueryVo.getPageSize());
        List<PaperVO> paperList = createPaperService.getPaper(paperQueryDto);
        PageInfo<PaperVO> pageInfo = new PageInfo(paperList);
        pageInfo.setTotal(objects.getTotal());
        return pageInfo;
    }
    CommonResponse downloadTemplatePaper(TemplateCombDTO templateCombDto){
        createPaperService.downLoadTemplate(templateCombDto);
        return CommonResponseUtil.ok("20000","模板组卷成功!");
    }
}

