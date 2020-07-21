package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.permission.api.OrganizationApi;
import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.pojo.vo.OrganizationVO;
import com.boss.xtrain.permission.service.OrganizationService;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Slf4j
@RestController
public class OrganizationController extends BaseController implements OrganizationApi {

    @Autowired
    private OrganizationService service;

    @ApiLog(msg = "添加新的组织机构")
    @Override
    @ApiOperation(value = "test")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<OrganizationDTO> request) {
        OrganizationDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.insert(dto));
    }

    @ApiLog(msg = "模糊查询组织机构")
    @Override
    @ApiOperation(value = "test")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<List<OrganizationVO>> selectList(@RequestBody @Valid CommonRequest<OrganizationQuery> request) {
        OrganizationQuery query = request.getBody();
        List<OrganizationDTO> organizationDTOList = service.selectByCondition(query);
        List<OrganizationVO> organizationVOList = PojoUtils.copyListProperties(organizationDTOList,OrganizationVO::new);
        return CommonResponseUtil.ok(organizationVOList);
    }

    @Override
    @ApiLog(msg = "搜索一个组织机构")
    @ApiOperation(value = "test")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<OrganizationVO> select(@Valid CommonRequest<OrganizationQuery> request) {
        OrganizationQuery query = request.getBody();
        OrganizationDTO organizationDTO = service.selectOne(query);
        OrganizationVO organizationVO = new OrganizationVO();
        PojoUtils.copyProperties(organizationDTO, organizationVO);
        return CommonResponseUtil.ok(organizationVO);
    }

    @ApiOperation(value = "test")
    @ApiLog(msg = "更新组织机构信息")
    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<OrganizationDTO> request) {
        OrganizationDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.update(dto));
    }

    /**
     * 根据ID删除啊！！
     * @param request
     * @return
     */
    @ApiOperation(value = "test")
    @ApiLog(msg = "删除一个组织机构")
    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<OrganizationDTO> request) {
        OrganizationDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.delete(dto));
    }

    /**
     * 批量删除
     * @param request 请求
     * @return 删除个数
     */
    @ApiLog(msg = "批量删除组织机构")
    @ApiOperation(value = "test")
    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<Integer> deleteBatch(@RequestBody @Valid CommonRequest<List<OrganizationDTO>> request) {
        List<OrganizationDTO> dtoList = request.getBody();
        return CommonResponseUtil.ok(service.delete(dtoList));
    }

    /**
     * 查所有
     *
     * @return list all
     */
    @ApiLog(msg = "搜索所有的组织机构")
    @Override
    @ApiOperation(value = "test")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<List<OrganizationVO>> selectAllOrg() {
        List<OrganizationDTO> organizationDTOList = service.selectAll();
        List<OrganizationVO> organizationVOList = PojoUtils.copyListProperties(organizationDTOList,OrganizationVO::new);
        return CommonResponseUtil.ok(organizationVOList);
    }

    @ApiLog(msg = "用主键搜索组织机构")
    @Override
    @ApiOperation(value = "test")
    public CommonResponse<OrganizationVO> selectByPrimaryKey(@RequestBody @Valid CommonRequest<OrganizationQuery> request) {
        OrganizationDTO dto = service.selectByPrimaryKey(request.getBody());
        OrganizationVO vo = new OrganizationVO();
        PojoUtils.copyProperties(dto,vo);
        return CommonResponseUtil.ok(vo);
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "分页全搜索组织机构并排序")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<CommonPage<OrganizationVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<OrganizationQuery>> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<OrganizationDTO> organizationDTOList = service.selectByCondition(request.getBody().getQuery());
        List<OrganizationVO> organizationVOList = PojoUtils.copyListProperties(organizationDTOList,OrganizationVO::new);
        return buildPageResponse(page,organizationVOList);
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "分页条件(模糊)搜索组织机构并排序")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('origanization_admin')")
    public CommonResponse<CommonPage<OrganizationVO>> selectAllByPage(@Valid CommonRequest<CommonPageRequest> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<OrganizationDTO> organizationDTOList = service.selectAll();
        List<OrganizationVO> organizationVOList = PojoUtils.copyListProperties(organizationDTOList,OrganizationVO::new);
        return buildPageResponse(page,organizationVOList);
    }
}