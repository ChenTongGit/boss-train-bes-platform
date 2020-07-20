package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.service.ResourceService;
import com.boss.xtrain.permission.api.ResourceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:06 2020/07/09
 * @Description :resource api实现
 * @Version: 1.0
 */

@RestController
public class ResourceController implements ResourceApi {

    @Autowired
    private ResourceService resourceService;

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('resource_admin')")
    public CommonResponse<Integer> insert(@Valid CommonRequest<ResourceDTO> request) {
        ResourceDTO dto = request.getBody();
        return CommonResponseUtil.ok(resourceService.insert(dto));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('resource_admin')")
    public CommonResponse<Integer> delete(@Valid CommonRequest<ResourceDTO> request) {
        ResourceDTO dto = request.getBody();
        return CommonResponseUtil.ok(resourceService.delete(dto));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('resource_admin')")
    public CommonResponse<List<ResourceListVO>> selectList(@Valid CommonRequest<ResourceQueryDTO> request) {
        ResourceQueryDTO dto = request.getBody();
        List<ResourceDTO> dtos = resourceService.selectByCondition(dto);
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(dtos,ResourceListVO::new));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('resource_admin')")
    public CommonResponse<ResourceListVO> select(@Valid CommonRequest<ResourceQueryDTO> request) {
        return null;
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('resource_admin')")
    public CommonResponse<Integer> update(@Valid CommonRequest<ResourceDTO> request) {
        ResourceDTO dto = request.getBody();
        return CommonResponseUtil.ok(resourceService.update(dto));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('resource_admin')")
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<ResourceDTO>> request) {
        List<ResourceDTO> resourceDTOS = request.getBody();
        return CommonResponseUtil.ok(resourceService.delete(resourceDTOS));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('resource_admin')")
    public CommonResponse<List<ResourceListVO>> selectAllResource() {
        List<ResourceDTO> dtos = resourceService.selectAll();
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(dtos,ResourceListVO::new));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('resource_admin')")
    public CommonResponse<CommonPage<ResourceListVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<ResourceQueryDTO>> request) {
        return null;
    }
}
