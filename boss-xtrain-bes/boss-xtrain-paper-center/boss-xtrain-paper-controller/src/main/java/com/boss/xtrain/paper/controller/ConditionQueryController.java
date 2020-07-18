package com.boss.xtrain.paper.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.ConditionQueryApi;
import com.boss.xtrain.paper.ConditionQueryPaperService;
import com.boss.xtrain.paper.dto.conditionquerypaper.QueryPaperDTO;
import com.boss.xtrain.paper.dto.conditionquerypaper.QueryPaperNameListDTO;
import com.boss.xtrain.paper.vo.conditionquerypaper.PaperNameVO;
import com.boss.xtrain.paper.vo.conditionquerypaper.PaperVO;
import com.boss.xtrain.paper.vo.conditionquerypaper.QueryPaperNameListVO;
import com.boss.xtrain.paper.vo.conditionquerypaper.QueryPaperVO;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @version: V1.0
 * @author: zjh
 * @className: ConditionQueryController
 * @packageName: com.boss.bes.paper.controller
 * @description: 条件查询搜索框
 * @data: 11:47 2020/2/6
 **/
@Api(tags={"条件查询"})
@RestController
public class ConditionQueryController extends BaseController implements ConditionQueryApi {

    @Autowired
    private ConditionQueryPaperService conditionQueryPaperService;
    /**
     * @param commonRequest
     * @methodsName: queryPaperNameTip
     * @description: 查询试卷名或模板名提示信息
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("查询热门试卷名集合")
    @Override
    public CommonResponse queryPaperNameTip(@RequestBody CommonRequest<QueryPaperNameListVO> commonRequest) {
        QueryPaperNameListVO queryPaperNameVo = commonRequest.getBody();
        QueryPaperNameListDTO queryPaperNameDto = new QueryPaperNameListDTO();
        PojoUtils.copyProperties(queryPaperNameVo,queryPaperNameDto);
        List<PaperNameVO> paperNameVos = conditionQueryPaperService.queryPaperName(queryPaperNameDto);
        return CommonResponseUtil.ok("20000","查询试卷名成功",paperNameVos);

    }

    @Override
    public String testfirst() {
        return "hello springboot";
    }


    /**
     * @param commonRequest
     * @methodsName: conditionQueryPaper
     * @description: 条件查询试卷
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("条件查询试卷")
    @Override
    public CommonResponse conditionQueryPaper(@RequestBody CommonRequest<QueryPaperDTO> commonRequest) {
        QueryPaperDTO queryPaperDto = commonRequest.getBody();

        Page<Object> objects = doBeforePagination(queryPaperDto.getPageNum(),queryPaperDto.getPageSize());
        List<PaperVO> paperVos = conditionQueryPaperService.queryPaperByCondition(queryPaperDto);
        PageInfo<PaperVO> pageInfo = new PageInfo(paperVos);
        pageInfo.setTotal(objects.getTotal());
        pageInfo.setPageNum(objects.getPageNum());
        pageInfo.setPageSize(objects.getPageSize());
        return CommonResponseUtil.ok("20000","条件查询试卷成功",buildPageResponse(pageInfo));
    }


}

