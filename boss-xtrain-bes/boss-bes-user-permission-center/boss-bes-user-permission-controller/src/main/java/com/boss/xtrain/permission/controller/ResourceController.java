package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.query.TreeNode;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.service.ResourceService;
import com.boss.xtrain.permission.api.ResourceApi;
import com.boss.xtrain.permission.service.TreeService;
import com.github.pagehelper.Page;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class ResourceController extends BaseController implements ResourceApi {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private TreeService treeService;
    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<ResourceDTO> request) {
        ResourceDTO dto = request.getBody();
        log.info(dto.toString());
        return CommonResponseUtil.ok(resourceService.insert(dto));
    }

    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<ResourceDTO> request) {
        ResourceDTO dto = request.getBody();
        log.info(dto.toString());
        return CommonResponseUtil.ok(resourceService.delete(dto));
    }

    @Override
    public CommonResponse<List<ResourceListVO>> selectList(@Valid CommonRequest<ResourceQueryDTO> request) {
        ResourceQueryDTO dto = request.getBody();
        List<ResourceDTO> dtos = resourceService.selectByCondition(dto);
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(dtos,ResourceListVO::new));
    }

    @Override
    public CommonResponse<ResourceListVO> select(@Valid CommonRequest<ResourceQueryDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<ResourceDTO> request) {
        ResourceDTO dto = request.getBody();
        return CommonResponseUtil.ok(resourceService.update(dto));
    }

    @Override
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<ResourceDTO>> request) {
        List<ResourceDTO> resourceDTOS = request.getBody();
        return CommonResponseUtil.ok(resourceService.delete(resourceDTOS));
    }

    @Override
    public CommonResponse<List<ResourceListVO>> selectAllResource() {
        List<ResourceDTO> dtos = resourceService.selectAll();
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(dtos,ResourceListVO::new));
    }

    @Override
    public CommonResponse<CommonPage<ResourceListVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<ResourceQueryDTO>> request) {
        Page<Object> page =  doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<ResourceDTO> companyDTOList = resourceService.selectByCondition(request.getBody().getQuery());
        log.info(companyDTOList.toString());
        if (request.getBody().getQuery().isSearchChild()) {
            ResourceQueryDTO d = new ResourceQueryDTO();
            d.setParentId(companyDTOList.get(0).getId());
            List<ResourceDTO> l = resourceService.selectByCondition(d);
            companyDTOList.addAll(l);
            log.info("result"+d.toString()+" "+l.toString());

        }
        List<ResourceListVO> companyVOList = PojoUtils.copyListProperties(companyDTOList,ResourceListVO::new);
        return buildPageResponse(page,companyVOList);
    }

    @Override
    public CommonResponse<CommonPage<ResourceListVO>> selectAllByPage(@Valid CommonRequest<CommonPageRequest> request) {
        Page<Object> page =  doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        log.info(page.toString());
        List<ResourceDTO> positionDTOList = resourceService.selectAll();
        List<ResourceListVO> positionVOList = PojoUtils.copyListProperties(positionDTOList, ResourceListVO::new);
        return buildPageResponse(page,positionVOList);
    }

    @Override
    public CommonResponse<List<TreeNode>> selectResourceTree(CommonRequest<ResourceQueryDTO> request) {
        return CommonResponseUtil.ok(treeService.resourceTree());

    }
}
