package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.api.DepartmentApi;
import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.pojo.vo.DepartmentVO;
import com.boss.xtrain.permission.service.DepartmentService;
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

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
@Slf4j
@RestController
public class DepartmentController extends BaseController implements DepartmentApi {

    @Autowired
    private DepartmentService service;
    /**
     * 批量删除
     *
     * @param request 请求
     * @return 删除个数
     */
    @Override
    @ApiLog(msg = "批量删除部门信息")
    @ApiOperation(value = "test")
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<DepartmentDTO>> request) {
        List<DepartmentDTO> dtoList = request.getBody();
        return CommonResponseUtil.ok(service.delete(dtoList));
    }

    /**
     * 查树
     *
     * @param request 请求
     * @return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "查找该组织机构下的公司及部门树节点")
    public CommonResponse<List<DepartmentQuery>> selectTree(@Valid CommonRequest<DepartmentQuery> request) {
        DepartmentQuery query = request.getBody();
        //至少userID信息不为空
        List<DepartmentQuery> departmentQueryList = service.selectTree(query);
        return CommonResponseUtil.ok(departmentQueryList);
    }

    /**
     * 初始化所有
     *
     * @param request request
     * @return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "查找该组织机构下的公司及部门")
    public CommonResponse<List<DepartmentVO>> selectAll(@Valid CommonRequest<DepartmentQuery> request) {
        DepartmentQuery query = request.getBody();
        //至少userId信息不为空
        List<DepartmentDTO> departmentDTOList = service.selectAll(query);
        List<DepartmentVO> departmentVOList = PojoUtils.copyListProperties(departmentDTOList,DepartmentVO::new);
        return CommonResponseUtil.ok(departmentVOList);
    }

    /**
     * 分页条件搜索
     *
     * @param request 请求
     * @return 分页搜索结果
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "分页条件搜索部门信息")
    public CommonResponse<CommonPage<DepartmentVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<DepartmentQuery>> request) {
        CommonPageRequest<DepartmentQuery> pageRequest = request.getBody();
        doBeforePagination(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<DepartmentDTO> departmentDTOList = service.selectByCondition(pageRequest.getQuery());
        List<DepartmentVO> departmentVOList = PojoUtils.copyListProperties(departmentDTOList,DepartmentVO::new);
        return buildPageResponse(new PageInfo<>(departmentVOList));
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "添加部门信息")
    public CommonResponse<Integer> insert(@Valid CommonRequest<DepartmentDTO> request) {
        DepartmentDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.insert(dto));
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "获取部门目录")
    public CommonResponse<List<DepartmentVO>> selectList(@Valid CommonRequest<DepartmentQuery> request) {
        DepartmentQuery query = request.getBody();
        List<DepartmentDTO> departmentDTOList = service.selectByCondition(query);
        List<DepartmentVO> departmentVOList = PojoUtils.copyListProperties(departmentDTOList,DepartmentVO::new);
        return CommonResponseUtil.ok(departmentVOList);
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "获取一个部门信息")
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
    public CommonResponse<Integer> update(@Valid CommonRequest<DepartmentDTO> request) {
        DepartmentDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.update(dto));
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "删除一条部门信息")
    public CommonResponse<Integer> delete(@Valid CommonRequest<DepartmentDTO> request) {
        DepartmentDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.delete(dto));
    }
}
