package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.api.SystemParamApi;
import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.permission.pojo.vo.SystemParamVO;
import com.boss.xtrain.permission.service.SystemParamService;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.github.pagehelper.Page;
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
public class SystemParamController extends BaseController implements SystemParamApi {

    @Autowired
    private SystemParamService service;

    /**
     * 批量删除
     *
     * @param request 请求
     * @return 删除个数
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "批量删除系统参数")
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<SystemParamDTO>> request) {
        List<SystemParamDTO> dtoList = request.getBody();
        return CommonResponseUtil.ok(service.delete(dtoList));
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "添加系统参数信息")
    public CommonResponse<Integer> insert(@Valid CommonRequest<SystemParamDTO> request) {
        SystemParamDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.insert(dto));
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "获取系统参数目录")
    public CommonResponse<List<SystemParamVO>> selectList(@Valid CommonRequest<SystemParamQuery> request) {
        SystemParamQuery query = request.getBody();
        List<SystemParamDTO> systemParamDTOList = service.selectByCondition(query);
        List<SystemParamVO> systemParamVOList = PojoUtils.copyListProperties(systemParamDTOList,SystemParamVO::new);
        return CommonResponseUtil.ok(systemParamVOList);
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "搜索一个系统参数")
    public CommonResponse<SystemParamVO> select(@Valid CommonRequest<SystemParamQuery> request) {
        SystemParamQuery query = request.getBody();
        SystemParamDTO systemParamDTO = service.selectOne(query);
        SystemParamVO systemParamVO = new SystemParamVO();
        PojoUtils.copyProperties(systemParamDTO,systemParamVO);
        return CommonResponseUtil.ok(systemParamVO);
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "更新系统参数信息")
    public CommonResponse<Integer> update(@Valid CommonRequest<SystemParamDTO> request) {
        SystemParamDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.update(dto));
    }

    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "删除一条系统参数信息")
    public CommonResponse<Integer> delete(@Valid CommonRequest<SystemParamDTO> request) {
        SystemParamDTO dto = request.getBody();
        return CommonResponseUtil.ok(service.delete(dto));
    }

    /**
     * 分页条件搜索
     *
     * @param request req
     * @return list page
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "分页条件搜索系统参数信息并排序")
    public CommonResponse<CommonPage<SystemParamVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<SystemParamQuery>> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<SystemParamDTO> systemParamDTOList = service.selectByCondition(request.getBody().getQuery());
        List<SystemParamVO> systemParamVOList = PojoUtils.copyListProperties(systemParamDTOList,SystemParamVO::new);
        return buildPageResponse(page,systemParamVOList);
    }

    /**
     * 分页全搜索
     *
     * @param request
     * @return
     */
    @Override
    public CommonResponse<CommonPage<SystemParamVO>> selectAllByPage(@Valid CommonRequest<CommonPageRequest<SystemParamQuery>> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<SystemParamDTO> systemParamDTOList = service.selectAllUnderOrg(request.getBody().getQuery());
        List<SystemParamVO> systemParamVOList = PojoUtils.copyListProperties(systemParamDTOList,SystemParamVO::new);
        return buildPageResponse(page,systemParamVOList);
    }

    /**
     * 禁用/启用 更改status
     *
     * @param request
     * @return
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "禁用/启用 该条系统参数")
    public CommonResponse<Integer> changeUse(@Valid CommonRequest<SystemParamDTO> request) {
        SystemParamDTO systemParamDTO = request.getBody();
        Integer status = systemParamDTO.getStatus();
        //禁用改启用
        if(status==0){
            systemParamDTO.setStatus(1);
        }else{
            //启用改禁用
            systemParamDTO.setStatus(0);
        }
        return CommonResponseUtil.ok(service.update(systemParamDTO));
    }
}
