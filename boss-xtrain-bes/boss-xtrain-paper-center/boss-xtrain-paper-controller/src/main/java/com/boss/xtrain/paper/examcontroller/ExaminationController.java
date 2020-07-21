package com.boss.xtrain.paper.examcontroller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.paper.ExamPaperService;
import com.boss.xtrain.paper.ExaminationApi;
import com.boss.xtrain.paper.controller.PaperBaseController;
import com.boss.xtrain.paper.dto.examservice.ExamPaperInfoQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;

import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;
import com.boss.xtrain.paper.vo.paperdetail.PaperQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = {"提供给考试服务的接口"})
@RestController
public class ExaminationController extends PaperBaseController implements ExaminationApi {
    @Autowired
    ExamPaperService examPaperService;

    /**
     * 获得所有试卷简要信息
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('examination_admin')")
    @ApiOperation("查询试卷集合")
    @Override
    public CommonResponse getAllPaper(@RequestBody CommonRequest<ExamPaperInfoQuery> commonRequest) {

        return CommonResponseUtil.ok(this.examPaperService.getExamPaperList(commonRequest.getBody()));
    }

    /**
     * 获得某一试卷详细信息
     *
     * @param
     * @return
     */
    @ApiOperation("查询某一试卷信息")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('examination_admin')")
    @Override
    public CommonResponse<ExamPaperDTO> getOnePaperWithSubject(@RequestBody @Valid CommonRequest<ExamPaperQuery> request) {
        ExamPaperDTO examPaperDTO = examPaperService.getExamPaper(request.getBody());
        return CommonResponseUtil.ok(examPaperDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('examination_admin')")
    @Override
    public CommonResponse getOnePaperAnswer(CommonRequest<ExamPaperQuery> commonRequest) {
        return null;
    }
}
