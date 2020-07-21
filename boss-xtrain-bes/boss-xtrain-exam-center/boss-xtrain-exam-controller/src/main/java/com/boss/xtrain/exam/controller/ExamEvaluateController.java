package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.api.ExamEvaluateApi;
import com.boss.xtrain.exam.pojo.dto.MarkingDataListDto;
import com.boss.xtrain.exam.pojo.dto.MarkingSubmitDTO;
import com.boss.xtrain.exam.pojo.dto.MarkingTempListDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.dto.query.MarkingQuery;
import com.boss.xtrain.exam.pojo.vo.MarkingDataListVO;
import com.boss.xtrain.exam.pojo.vo.PaperSubjectAnswerVO;
import com.boss.xtrain.exam.service.ExamEvaluateService;
import com.boss.xtrain.exam.service.ExamRecordService;
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

import javax.validation.Valid;
import java.util.List;

/**
 * 考试评卷逻辑控制器
 *
 * @author ChenTong
 * @version 2.0
 * @date 2020/7/14 22:27
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Slf4j
@RequestMapping(CommonConstant.BASIC_URL+"/exam/evaluate")
@RestController
@Api(value = "考试评卷管理Controller" , tags = {"考试评卷管理操作接口"})
public class ExamEvaluateController extends BaseController implements ExamEvaluateApi {

    @Autowired
    private ExamEvaluateService examEvaluateService;

    @Autowired
    private ExamRecordService examRecordService;

    /**
     * 获取阅卷部分的考试记录列表
     *
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.common.core.http.CommonPage < com.boss.xtrain.exam.pojo.vo.MarkingDataListVO>>
     * @author ChenTong
     * @date 2020/7/14 22:27
     */
    @ApiOperation(value = "获取评卷列表")
    @PostMapping("/list")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_evalute_admin')")
    @Override
    public CommonResponse<CommonPage<MarkingDataListVO>> doQueryExamRecord(@Valid @RequestBody CommonRequest<CommonPageRequest<MarkingQuery>> request) {
        Page<Object> page = this.doBeforePagination(request.getBody().getPageNum(), request.getBody().getPageSize(), request.getBody().getOrderBy());
        List<MarkingDataListDto> markingDataListDtos = this.examEvaluateService.queryByCondition(request.getBody().getQuery());
        List<MarkingDataListVO>  markingDataListVOS = PojoUtils.copyListProperties(markingDataListDtos, MarkingDataListVO::new);
        return buildPageResponse(page, markingDataListVOS);
    }

    /**
     * 临时保存回传的阅卷结果信息
     *
     * @param request 请求
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Boolean>
     * @author ChenTong
     * @date 2020/7/16 14:52
     */
    @ApiOperation(value = "回传阅卷结果临时存储")
    @PostMapping("/tempMarkingResult")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_evalute_admin')")
    @Override
    public CommonResponse<Boolean> tempMarkingRecord(@Valid @RequestBody CommonRequest<MarkingTempListDTO> request) {
        this.examEvaluateService.tempEvaluateResult(request.getBody().getList(),request.getBody().getExamRecordId());
        return CommonResponseUtil.ok(true);
    }

    /**
     * 提交批卷记录
     * @param request
     * @return
     */
    @ApiOperation(value = "提交保存阅卷信息")
    @PostMapping("/submit")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_evalute_admin')")
    @Override
    public CommonResponse<Boolean> submitEvaluate(@Valid @RequestBody CommonRequest<MarkingSubmitDTO> request) {
        Boolean result = this.examEvaluateService.submitEvaluate(request.getBody());
        return CommonResponseUtil.ok(result);
    }

    /**
     * 获取前端，答卷详情需要的完整的试卷
     *
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<PaperSubjectAnswerVO>
     * @author ChenTong
     * @date 2020/7/19 14:43
     */
    @PostMapping("/paper")
    @ApiOperation(value = "获取试卷")
    @Override
    public CommonResponse<PaperSubjectAnswerVO> doQueryExamEvaluateDetail(@RequestBody @Valid CommonRequest<SubmitExamDTO> request) {
        return CommonResponseUtil.ok(this.examRecordService.getCompletePaper(request.getBody(), true));
    }
}
