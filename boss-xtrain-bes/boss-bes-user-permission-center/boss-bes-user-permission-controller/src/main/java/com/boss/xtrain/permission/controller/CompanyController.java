package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.api.CompanyApi;
import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.vo.CompanyVO;
import com.boss.xtrain.permission.service.CompanyService;
import com.boss.xtrain.common.core.exception.ServiceException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
    public CommonResponse<Integer> deleteBatch(@RequestBody @Valid CommonRequest<List<CompanyDTO>> request) {
        List<CompanyDTO> dtoList = request.getBody();
        try{
            Integer count = service.delete(dtoList);
            String msg = "成功删除了"+count+"个数据";
            return CommonResponseUtil.ok(msg,count.toString());
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR);
        }
    }

    /**
     * 查所有
     *
     * @return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @ApiLog(msg = "初始化组织机构下所有的公司")
    public CommonResponse<List<CompanyVO>> selectAllCompany(@Valid CommonRequest<CompanyQuery> request) {
        CompanyQuery query = request.getBody();
        try{
            List<CompanyDTO> companyDTOList = service.selectOrgCompanyAll(query);
            List<CompanyVO> companyVOList = PojoUtils.copyListProperties(companyDTOList,CompanyVO::new);
            return CommonResponseUtil.ok(companyVOList);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR);
        }
    }

    /**
     * 分页条件搜索
     *
     * @param request
     * @return
     */
    @Override
    @ApiLog(msg = "分页条件搜索公司信息")
    public CommonResponse<CommonPage<CompanyVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<CompanyQuery>> request) {
        CommonPageRequest<CompanyQuery> pageRequest = request.getBody();
        doBeforePagination(pageRequest.getPageNum(),pageRequest.getPageSize());
        try{
            List<CompanyDTO> companyDTOList = service.selectByCondition(pageRequest.getQuery());
            List<CompanyVO> companyVOList = PojoUtils.copyListProperties(companyDTOList,CompanyVO::new);
            return buildPageResponse(new PageInfo<>(companyVOList));
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "添加公司信息")
    public CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        CompanyDTO dto = request.getBody();
        try{
            Integer res = service.insert(dto);
            if(res==-1){
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_REPEAT_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_INSERT_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "获取公司信息")
    @ApiOperation(value = "test")
    public CommonResponse<List<CompanyVO>> selectList(@RequestBody @Valid CommonRequest<CompanyQuery> request) {
        CompanyQuery query = request.getBody();
        try{
            List<CompanyDTO> companyDTOList = service.selectByCondition(query);
            List<CompanyVO> companyVOList = PojoUtils.copyListProperties(companyDTOList,CompanyVO::new);
            return CommonResponseUtil.ok(companyVOList);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR);
        }
    }

    @Override
    public CommonResponse<CompanyVO> select(@RequestBody @Valid CommonRequest<CompanyQuery> request) {
        CompanyQuery query = request.getBody();
        try{
            CompanyDTO companyDTO = service.selectOne(query);
            CompanyVO companyVO = new CompanyVO();
            PojoUtils.copyProperties(companyDTO,companyVO);
            return CommonResponseUtil.ok(companyVO);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "更新公司信息")
    public CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        CompanyDTO dto = request.getBody();
        try{
            Integer res = service.update(dto);
            if(res==-1){
                //数据不存在无法更改
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_UPDATE_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_UPDATE_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "删除一条公司信息")
    public CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        CompanyDTO dto = request.getBody();
        try{
            Integer res = service.delete(dto);
            if(res==-1){
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR);
        }
    }
}
