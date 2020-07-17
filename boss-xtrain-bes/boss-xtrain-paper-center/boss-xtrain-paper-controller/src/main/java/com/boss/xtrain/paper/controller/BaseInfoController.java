package com.boss.xtrain.paper.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.paper.BaseInfoApi;
import com.boss.xtrain.paper.BaseServiceApi;
import com.boss.xtrain.paper.BaseServiceApiImpl;
import com.boss.xtrain.paper.dto.baseinfo.CombInfoQueryDTO;
import com.boss.xtrain.paper.vo.baseinfo.CombInfoQueryVO;
import com.boss.xtrain.paper.vo.baseinfo.SubjectCategoryVO;
import com.boss.xtrain.paper.vo.baseinfo.SubjectTypeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags={"获取题目和试卷属性"})
@RestController
@Slf4j
public class BaseInfoController extends BaseController implements BaseInfoApi {
    @Autowired
    private BaseServiceApiImpl baseServiceApi;

    @ApiOperation("查询题目类型集合")
    @Override
    public CommonResponse querySubjectCategoryList(@RequestBody CommonRequest<CombInfoQueryDTO> commonRequest) {
        CombInfoQueryDTO combInfoQueryDTO = commonRequest.getBody();
        List<SubjectCategoryVO> subjectCategoryList = baseServiceApi.querySubjectCategory(combInfoQueryDTO);
        return CommonResponseUtil.ok("20000","成功查询题目类型集合",subjectCategoryList);
    }

    @ApiOperation("查询题型集合")
    @Override
    public CommonResponse querySubjectTypeList(@RequestBody CommonRequest<CombInfoQueryDTO> commonRequest) {
        CombInfoQueryDTO combInfoQueryDTO = commonRequest.getBody();
        List<SubjectTypeVO> subjectTypeList = baseServiceApi.querySubjectType(combInfoQueryDTO);
        return CommonResponseUtil.ok("20000","成功查询题型集合",subjectTypeList);
    }

    @ApiOperation("查询试卷类型、试卷难度、题目难度集合")
    @Override
    public CommonResponse queryPaperInfo(@RequestBody CommonRequest<CombInfoQueryDTO> commonRequest) {
        CombInfoQueryDTO combInfoQueryDTO = commonRequest.getBody();
        List<SubjectTypeVO> subjectTypeList = baseServiceApi.queryPaperSubjectType(combInfoQueryDTO);
       return CommonResponseUtil.ok("20000","成功查询集合",subjectTypeList);
    }

    @ApiOperation("查询公司集合")
    @Override
    public CommonResponse queryCompanyList(@RequestBody CommonRequest<CombInfoQueryVO> commonRequest) {
        return null;
    }
}


