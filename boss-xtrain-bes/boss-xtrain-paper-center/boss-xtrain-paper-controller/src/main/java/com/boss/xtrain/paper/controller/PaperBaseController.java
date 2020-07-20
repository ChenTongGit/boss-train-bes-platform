package com.boss.xtrain.paper.controller;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.papaer.utils.BasicConverter;
import com.boss.xtrain.papaer.utils.BeanCopierUtil;
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
import org.springframework.security.access.prepost.PreAuthorize;

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

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('paper_base_admin')")
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
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('paper_base_admin')")
    protected PageInfo queryPaperList(PaperQueryVO paperQueryVo){
        PaperQueryDTO paperQueryDto = new PaperQueryDTO();
        BeanCopierUtil.copy(paperQueryVo,paperQueryDto,new BasicConverter());
        //设置分页信息
        Page<Object> objects = doBeforePagination(paperQueryVo.getPageNum(),paperQueryVo.getPageSize());
        List<PaperVO> paperList = createPaperService.getPaper(paperQueryDto);
        PageInfo<PaperVO> pageInfo = new PageInfo(paperList);
        pageInfo.setTotal(objects.getTotal());
        return pageInfo;
    }
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('paper_base_admin')")
    CommonResponse downloadTemplatePaper(TemplateCombDTO templateCombDto){
        try{
            createPaperService.downLoadTemplate(templateCombDto);
        }catch (BusinessException e){
            return CommonResponseUtil.error(e.getCode(),e.getMessage());
        }
        return CommonResponseUtil.ok("20000","模板组卷成功!");
    }
}

