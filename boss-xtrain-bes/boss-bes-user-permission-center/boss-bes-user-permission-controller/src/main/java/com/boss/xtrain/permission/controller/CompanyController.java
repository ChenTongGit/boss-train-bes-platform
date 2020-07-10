package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.api.CompanyApi;
import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.vo.CompanyVO;
import com.boss.xtrain.permission.service.CompanyService;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
@Slf4j
@RestController
public class CompanyController extends BaseController implements CompanyApi {

    @Autowired
    private CompanyService service;

    /**
     * 批量删除
     *
     * @param request 请求
     * @return 删除个数
     */
    @Override
    @ApiLog(msg = "批量删除公司信息")
    @ApiOperation(value = "test")
    public CommonResponse<Integer> deleteBatch(@RequestBody @Valid CommonRequest<List<CompanyDTO>> request) {
        List<CompanyDTO> dtoList = request.getBody();
        return CommonResponseUtil.ok(service.delete(dtoList));
    }

    /**
     * 查所有
     *
     * @return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @ApiLog(msg = "初始化组织机构下所有的公司")
    @ApiOperation(value = "test")
    public CommonResponse<List<CompanyVO>> selectAllCompany(@Valid CommonRequest<CompanyQuery> request) {
        CompanyQuery query = request.getBody();
        List<CompanyDTO> companyDTOList = service.selectOrgCompanyAll(query);
        List<CompanyVO> companyVOList = PojoUtils.copyListProperties(companyDTOList,CompanyVO::new);
        return CommonResponseUtil.ok(companyVOList);
    }

    /**
     * 分页条件搜索
     *
     * @param request 请求
     * @return 分页搜索结果
     */
    @Override
    @ApiLog(msg = "分页条件搜索公司信息")
    @ApiOperation(value = "test")
    public CommonResponse<CommonPage<CompanyVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<CompanyQuery>> request) {
        CommonPageRequest<CompanyQuery> pageRequest = request.getBody();
        doBeforePagination(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<CompanyDTO> companyDTOList = service.selectByCondition(pageRequest.getQuery());
        List<CompanyVO> companyVOList = PojoUtils.copyListProperties(companyDTOList,CompanyVO::new);
        return buildPageResponse(new PageInfo<>(companyVOList));
    }

    @Override
    @ApiLog(msg = "添加公司信息")
    @ApiOperation(value = "test")
    public CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        CompanyDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.insert(dto));
    }

    @Override
    @ApiLog(msg = "获取公司信息")
    @ApiOperation(value = "test")
    public CommonResponse<List<CompanyVO>> selectList(@RequestBody @Valid CommonRequest<CompanyQuery> request) {
        CompanyQuery query = request.getBody();
        List<CompanyDTO> companyDTOList = service.selectByCondition(query);
        List<CompanyVO> companyVOList = PojoUtils.copyListProperties(companyDTOList,CompanyVO::new);
        return CommonResponseUtil.ok(companyVOList);
    }

    @Override
    @ApiLog(msg = "搜索一条公司信息")
    @ApiOperation(value = "test")
    public CommonResponse<CompanyVO> select(@RequestBody @Valid CommonRequest<CompanyQuery> request) {
        CompanyQuery query = request.getBody();
        CompanyDTO companyDTO = service.selectOne(query);
        CompanyVO companyVO = new CompanyVO();
        PojoUtils.copyProperties(companyDTO,companyVO);
        return CommonResponseUtil.ok(companyVO);
    }

    @Override
    @ApiLog(msg = "更新公司信息")
    @ApiOperation(value = "test")
    public CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        CompanyDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.update(dto));
    }

    @Override
    @ApiLog(msg = "删除一条公司信息")
    @ApiOperation(value = "test")
    public CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        CompanyDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.delete(dto));
    }
}
