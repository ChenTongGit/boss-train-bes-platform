package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.api.ExamRecordApi;
import com.boss.xtrain.exam.configuration.TokenUtil;
import com.boss.xtrain.exam.pojo.dto.ExamRecordDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.vo.ExamRecordVO;
import com.boss.xtrain.exam.pojo.vo.PaperSubjectAnswerVO;
import com.boss.xtrain.exam.service.ExamRecordService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * 考试记录逻辑控制器
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/11 14:57
 * @copyright
 * @modified
 * @see
 * @since
 **/
@RestController
@RequestMapping(CommonConstant.BASIC_URL+"/examRecord")
@Api(value = "考试记录Controller" , tags = {"考试记录操作接口"})
@Slf4j
public class ExamRecordController extends BaseController implements ExamRecordApi {

    @Autowired
    private ExamRecordService examRecordService;
    /**
     * 根据查询条件获取所有的考试记录 companyID
     *
     * @param request
     * @return CommonResponse<CommonPage < ExamRecordVO>>
     * @author ChenTong
     * @date 2020/7/11 0:37
     */
    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_record_admin')")
    @ApiOperation(value = "获取答卷列表")
    public CommonResponse<CommonPage<ExamRecordVO>> findExamRecordByPage(@Valid CommonRequest<CommonPageRequest<ExamRecordQuery>> request) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Long companyId = TokenUtil.getCompanyId(attributes);
        ExamRecordQuery query = request.getBody().getQuery();
        if(companyId!=-1L){
            log.info("current company"+companyId);
            query.setCompanyId(companyId);
        }
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<ExamRecordDTO> examRecordDTOS = this.examRecordService.queryForCondition(query);
        List<ExamRecordVO> examRecordVOS = PojoUtils.copyListProperties(examRecordDTOS, ExamRecordVO::new);
        return buildPageResponse(page,examRecordVOS);
    }

    /**
     * 通过考试记录id获取具体的答卷情况
     *
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<AnserPaperDetailsVO>
     * @author ChenTong
     * @date 2020/7/11 0:41
     */
    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_record_admin')")
    @ApiOperation(value = "获取答卷详情")
    public CommonResponse<PaperSubjectAnswerVO> findAnswerPaperDetail(@Valid CommonRequest<SubmitExamDTO> request) {
        return CommonResponseUtil.ok(this.examRecordService.getCompletePaper(request.getBody(), false));
    }
}
