package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.api.DepartmentApi;
import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.query.CompanyDepartmentNode;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.pojo.vo.DepartmentVO;
import com.boss.xtrain.permission.service.DepartmentService;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.permission.service.TreeService;
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
 * @date 2020.07.07
 */
@Slf4j
@RestController
public class DepartmentController extends BaseController implements DepartmentApi {

    @Autowired
    private DepartmentService service;

    @Autowired
    private TreeService treeService;

    /**
     * 批量删除
     *
     * @param request 请求
     * @return 删除个数
     */
    @Override
    @ApiLog(msg = "批量删除部门信息")
    @ApiOperation(value = "test")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<DepartmentDTO>> request) {
        List<DepartmentDTO> dtoList = request.getBody();
        return CommonResponseUtil.ok(service.delete(dtoList));
    }

    /**
     * 查树
     *
     * @param
     * @return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @ApiOperation(value = "test")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    @ApiLog(msg = "查找公司节点")
    @ResponseBody
    public CommonResponse<List<CompanyQuery>> selectTree() {
        try{
            return CommonResponseUtil.ok(treeService.companyTree());
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR,e);
        }
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "查找公司下的部门树节点")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    @ResponseBody
    public CommonResponse<List<CompanyDepartmentNode>> selectDepartmentTree(@Valid CommonRequest<CompanyQuery> request) {
        try{
            List<CompanyDepartmentNode> treeList = treeService.departmentUnderCompany(request.getBody());
            return CommonResponseUtil.ok(treeList);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR,e);
        }
    }


    /**
     * 分页搜索
     *
     * @param request 请求
     * @return 分页搜索结果
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "分页搜索所有部门信息并排序")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    public CommonResponse<CommonPage<DepartmentVO>> selectAllByPage(@Valid CommonRequest<CommonPageRequest> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<DepartmentDTO> companyDTOList = service.selectAll();
        List<DepartmentVO> companyVOList = PojoUtils.copyListProperties(companyDTOList,DepartmentVO::new);
        return buildPageResponse(page,companyVOList);
    }

    @ApiLog(msg = "用主键搜索部门信息")
    @Override
    @ApiOperation(value = "test")
    public CommonResponse<DepartmentVO> selectByPrimaryKey(@RequestBody @Valid CommonRequest<DepartmentQuery> request) {
        DepartmentDTO departmentDTO = service.selectByPrimaryKey(request.getBody());
        DepartmentVO vo = new DepartmentVO();
        PojoUtils.copyProperties(departmentDTO,vo);
        return CommonResponseUtil.ok(vo);
    }

    /**
     * 初始化所有分页
     *
     * @param request@return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "分页条件搜索部门信息并排序")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    public CommonResponse<CommonPage<DepartmentVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<DepartmentQuery>> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<DepartmentDTO> departmentDTOList = service.selectByCondition(request.getBody().getQuery());
        List<DepartmentVO> departmentVOList = PojoUtils.copyListProperties(departmentDTOList,DepartmentVO::new);
        return buildPageResponse(page,departmentVOList);
    }

    /**
     * 初始化所有
     *
     * @param
     * @return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @ApiOperation(value = "test")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    @ApiLog(msg = "无条件查找所有的部门")
    public CommonResponse<List<DepartmentVO>> selectAll() {
        List<DepartmentDTO> departmentDTOList = service.selectAll();
        List<DepartmentVO> departmentVOList = PojoUtils.copyListProperties(departmentDTOList,DepartmentVO::new);
        return CommonResponseUtil.ok(departmentVOList);
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "添加部门信息")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    public CommonResponse<Integer> insert(@Valid CommonRequest<DepartmentDTO> request) {
        DepartmentDTO dto = request.getBody();
//        Long createdBy = token获取userID
        Long createdBy = null;
        dto.setCreatedBy(createdBy);
        return CommonResponseUtil.ok(service.insert(dto));
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "获取部门目录")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    public CommonResponse<List<DepartmentVO>> selectList(@Valid CommonRequest<DepartmentQuery> request) {
        DepartmentQuery query = request.getBody();
        List<DepartmentDTO> departmentDTOList = service.selectByCondition(query);
        List<DepartmentVO> departmentVOList = PojoUtils.copyListProperties(departmentDTOList,DepartmentVO::new);
        return CommonResponseUtil.ok(departmentVOList);
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "获取一个部门信息")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    public CommonResponse<DepartmentVO> select(@Valid CommonRequest<DepartmentQuery> request) {
        DepartmentQuery query = request.getBody();
        DepartmentDTO organizationDTO = service.selectOne(query);
        DepartmentVO departmentVO = new DepartmentVO();
        PojoUtils.copyProperties(organizationDTO,departmentVO);
        return CommonResponseUtil.ok(departmentVO);
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "更新部门信息")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    public CommonResponse<Integer> update(@Valid CommonRequest<DepartmentDTO> request) {
        DepartmentDTO dto = request.getBody();
//        Long updateUser = token;从token中获得更新人id
//        dto.setUpdatedBy(updateUser);
        return CommonResponseUtil.ok(service.update(dto));
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "删除一条部门信息")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('department_admin')")
    public CommonResponse<Integer> delete(@Valid CommonRequest<DepartmentDTO> request) {
        DepartmentDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.delete(dto));
    }
}