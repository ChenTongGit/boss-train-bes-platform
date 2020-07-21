package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.RoleResourceDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import com.boss.xtrain.permission.service.RoleService;
import com.boss.xtrain.permission.api.RoleApi;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:37 2020/07/09
 * @Description :role api实现
 * @Version: 1.0
 */

@RestController
@Slf4j
public class RoleController extends BaseController implements RoleApi {

    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('role_admin')")
    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<RoleDTO> request) {
        RoleDTO roleDTO = request.getBody();
        return CommonResponseUtil.ok(roleService.insert(roleDTO));
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('role_admin')")
    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<RoleDTO> request) {
        RoleDTO roleDTO = request.getBody();
        return CommonResponseUtil.ok(roleService.delete(roleDTO));
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('role_admin')")
    @Override
    public CommonResponse<List<RoleListVO>> selectList(@Valid CommonRequest<RoleQueryDTO> request) {
        RoleQueryDTO queryDTO = request.getBody();
        List<RoleDTO> roleDTOS = roleService.selectByCondition(queryDTO);
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(roleDTOS,RoleListVO::new));
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('role_admin')")
    @Override
    public CommonResponse<RoleListVO> select(@Valid CommonRequest<RoleQueryDTO> request) {
        RoleQueryDTO queryDTO = request.getBody();
        RoleDTO result = roleService.selectByCondition(queryDTO).get(0);
        RoleListVO vo = new RoleListVO();
        PojoUtils.copyProperties(result,vo);
        return CommonResponseUtil.ok(vo);
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('role_admin')")
    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<RoleDTO> request) {
        return CommonResponseUtil.ok(roleService.update(request.getBody()));
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('role_admin')")
    @Override
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<RoleDTO>> request) {
        return CommonResponseUtil.ok(roleService.delete(request.getBody()));
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('role_admin')")
    @Override
    public CommonResponse<CommonPage<RoleListVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<RoleQueryDTO>> request) {
        Page<Object> page =  doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<RoleDTO> companyDTOList = roleService.selectByCondition(request.getBody().getQuery());
        log.info(companyDTOList.toString());
        List<RoleListVO> roleVOList = PojoUtils.copyListProperties(companyDTOList,RoleListVO::new);
        return buildPageResponse(page,roleVOList);
    }

    @Override
    public CommonResponse<CommonPage<RoleListVO>> selectAllByPage(@Valid CommonRequest<CommonPageRequest> request) {
        Page<Object> page =  doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        log.info(page.toString());
        List<RoleDTO> positionDTOList = roleService.selectAll();
        List<RoleListVO> roleListVOS = PojoUtils.copyListProperties(positionDTOList, RoleListVO::new);
        return buildPageResponse(page,roleListVOS);
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('role_admin')")
    @Override
    public CommonResponse<List<RoleListVO>> selectAllRole(){
        List<RoleDTO> roleDTOS = roleService.selectAll();
        log.info(roleDTOS.toString());
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(roleDTOS,RoleListVO::new));
    }

    @Override
    public CommonResponse<List<Long>> getResourceIds(@Valid CommonRequest<RoleQueryDTO> dtoCommonRequest) {
        RoleQueryDTO body = dtoCommonRequest.getBody();
        Long id =body.getId();
        List<Long> resourceIds = roleService.getResourceIdsByRoleId(id);
        return CommonResponseUtil.ok(resourceIds);
    }

    @Override
    public CommonResponse<List<Long>> getUserIds(@Valid CommonRequest<RoleQueryDTO> dtoCommonRequest) {
        RoleQueryDTO body = dtoCommonRequest.getBody();
        Long id =body.getId();
        List<Long> userIds = roleService.getUserIdsByRoleId(id);
        return CommonResponseUtil.ok(userIds);
    }

    @Override
    public CommonResponse<Boolean> allocateResource(@Valid CommonRequest<List<RoleResourceDTO>> request) {
        List<RoleResourceDTO> roleResourceDTOS = request.getBody();
        boolean result = roleService.allocateResource(roleResourceDTOS);
        return CommonResponseUtil.ok(result);
    }

    @Override
    public CommonResponse<Boolean> allocateUser(@Valid CommonRequest<List<UserRoleDTO>> request) {
        List<UserRoleDTO> userRoleDTOS = request.getBody();
        boolean result = roleService.allocateUser(userRoleDTOS);
        return CommonResponseUtil.ok(result);
    }

}
