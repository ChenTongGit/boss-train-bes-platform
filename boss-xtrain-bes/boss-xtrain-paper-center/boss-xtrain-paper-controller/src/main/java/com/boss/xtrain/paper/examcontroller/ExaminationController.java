package com.boss.xtrain.paper.examcontroller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.paper.ExamService;
import com.boss.xtrain.paper.ExaminationApi;
import com.boss.xtrain.paper.controller.PaperBaseController;
import com.boss.xtrain.paper.dto.examservice.ExamServiceQueryPaperDTO;

import com.boss.xtrain.paper.dto.examservice.PaperAllMsgDTO;
import com.boss.xtrain.paper.vo.paperdetail.PaperQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = {"提供给考试服务的接口"})
@RestController
public class ExaminationController extends PaperBaseController implements ExaminationApi {
    @Autowired
    ExamService examService;

    /**
     * 获得所有试卷简要信息
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('examination_admin')")
    @ApiOperation("查询试卷集合")
    @Override
    public CommonResponse getAllPaper(@RequestBody CommonRequest<PaperQueryVO> commonRequest) {

        return CommonResponseUtil.ok("20000","查询试卷成功",queryPaperList(commonRequest.getBody()));
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
    public CommonResponse getOnePaperWithSubject(@RequestBody CommonRequest<ExamServiceQueryPaperDTO> commonRequest) {
        PaperAllMsgDTO paperAllMsgDTO= examService.getOnePaperMsg(commonRequest.getBody());
        return CommonResponseUtil.ok("20000","查询信息成功",paperAllMsgDTO);
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('examination_admin')")
    @Override
    public CommonResponse getOnePaperAnswer(CommonRequest<ExamServiceQueryPaperDTO> commonRequest) {
        return null;
    }
}
