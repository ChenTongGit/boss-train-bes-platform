package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.api.ExamReportApi;
import com.boss.xtrain.exam.configuration.TokenUtil;
import com.boss.xtrain.exam.pojo.dto.ReportDataItemDTO;
import com.boss.xtrain.exam.pojo.dto.ReportDataListDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.dto.query.ExamReportQuery;
import com.boss.xtrain.exam.pojo.dto.query.ReportDetailQuery;
import com.boss.xtrain.exam.pojo.vo.ReportDataItemVO;
import com.boss.xtrain.exam.pojo.vo.ReportDataListVO;
import com.boss.xtrain.exam.service.ExamReportService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ChenTong
 * @date 2020/7/13 23:03
 * @copyright
 * @modified
 * @see
 * @since
 **/
@RestController
@RequestMapping(CommonConstant.BASIC_URL+"/examReport")
@Api(value = "考试报表Controller" , tags = {"考试报表操作接口"})
@Slf4j
public class ExamReportController extends BaseController implements ExamReportApi {

    @Autowired
    private ExamReportService examReportService;

    @ApiOperation(value = "获取报表细节")
    @PostMapping("/examReportDetail")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_report_admin')")
    @Override
    public CommonResponse<CommonPage<ReportDataItemVO>> queryExamReport(@RequestBody @Valid CommonRequest<CommonPageRequest<ReportDetailQuery>> request) {
        Page<Object> page =doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<ReportDataItemDTO> dtos = examReportService.queryDetail(
               request.getBody().getQuery().getPublishId());
        List<ReportDataItemVO> vos = PojoUtils.copyListProperties(dtos,ReportDataItemVO::new);
        return buildPageResponse(page,vos);
    }

    @PostMapping("/examReport")
    @ApiOperation(value = "获取报表信息")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_report_admin')")
    @Override
    public CommonResponse<CommonPage<ReportDataListVO>> doQueryExamReport(@RequestBody @Valid CommonRequest<CommonPageRequest<ExamReportQuery>> request) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Long companyId = TokenUtil.getCompanyId(attributes);
        ExamReportQuery query = request.getBody().getQuery();
        if(companyId!=-1L){
            log.info("current company"+companyId);
            query.setCompanyId(companyId);
        }
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(), request.getBody().getPageSize(), request.getBody().getOrderBy());
        List<ReportDataListDTO> dtos = examReportService.queryListByCondition(query);
        List<ReportDataListVO> vos = PojoUtils.copyListProperties(dtos, ReportDataListVO::new);
        return buildPageResponse(page, vos);
    }
}
