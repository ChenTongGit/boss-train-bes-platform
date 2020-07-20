package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.api.ExamApi;
import com.boss.xtrain.exam.pojo.dto.AnswerRecordTempInsertDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO;
import com.boss.xtrain.exam.pojo.dto.ExamStartAddRecordDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPaperInfoQuery;
import com.boss.xtrain.exam.pojo.vo.ExamBasicInfoVO;
import com.boss.xtrain.exam.pojo.vo.ExamRecordIdVO;
import com.boss.xtrain.exam.pojo.vo.PaperSubjectAnswerVO;
import com.boss.xtrain.exam.service.ExamPublishRecordService;
import com.boss.xtrain.exam.service.ExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 手机答卷逻辑控制器
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 11:58
 * @copyright
 * @modified
 * @see
 * @since
 **/
@RestController
@RequestMapping(CommonConstant.BASIC_URL+"/exam")
@Api(value = "手机答卷Controller" , tags = {"手机答卷"})
public class ExamController implements ExamApi {

    @Autowired
    private ExamPublishRecordService examPublishRecordService;

    @Autowired
    private ExamService examService;

    @ApiLog(msg = "考试开始获取基础的考试信息")
    @ApiOperation(value = "获取基础的考试发布信息")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_admin')")
    @Override
    public CommonResponse<ExamBasicInfoVO> getExamBasicInfo(@Valid CommonRequest<ExamPaperInfoQuery> request) {
        ExamPublishRecordDTO dto = examPublishRecordService.selectOne(request.getBody().getExamPublishRecordId());
        ExamBasicInfoVO examBasicInfoVO = new ExamBasicInfoVO();
        PojoUtils.copyProperties(dto, examBasicInfoVO);
        return CommonResponseUtil.ok(examBasicInfoVO);
    }

    @ApiLog(msg = "考试开始初次添加考试记录,并分配阅卷人员以及阅卷时间")
    @ApiOperation(value = "考试开始，初次添加考试记录")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_admin')")
    @Override
    public CommonResponse<ExamRecordIdVO> createExamRecord(@Valid CommonRequest<ExamStartAddRecordDTO> request) {
        ExamRecordIdVO result = new ExamRecordIdVO();
        result.setExamRecordId(examService.insertBasicExamRecord(request.getBody()));
        return CommonResponseUtil.ok(result);
    }

    @ApiLog(msg = "暂时存储考生答案")
    @ApiOperation(value = "考试过程暂时保存答案")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_admin')")
    @Override
    public CommonResponse<Integer> saveTempAnswers(@Valid CommonRequest<List<AnswerRecordTempInsertDTO>> request) {
        return CommonResponseUtil.ok(examService.insertTemAnswerRecord(request.getBody()));
    }

    @ApiLog(msg = "提交考试")
    @ApiOperation(value = "提交考试")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('exam_admin')")
    @Override
    public CommonResponse<Integer> submitExam(@Valid CommonRequest<SubmitExamDTO> request) {
        return CommonResponseUtil.ok(examService.submitExam(request.getBody()));
    }

    /**
     * 获取考试格式的试卷（没有正确答案标识，以免拦截请求泄露信息）
     * 如果redis存在，同时取出redis中的答案并合并
     *
     * @param request
     * @return
     */
    @ApiLog(msg = "获取考试")
    @ApiOperation(value = "获取考试试卷")
    @Override
    @PostMapping("/examPaper")
    public CommonResponse<PaperSubjectAnswerVO> getExamPaper(@RequestBody @Valid CommonRequest<SubmitExamDTO> request) {
        return CommonResponseUtil.ok(examService.getPaper(request.getBody(), true));
    }

}
