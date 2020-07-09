package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.api.SystemParamApi;
import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.permission.pojo.vo.SystemParamVO;
import com.boss.xtrain.permission.service.SystemParamService;
import com.boss.xtrain.common.core.exception.ServiceException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.github.pagehelper.PageInfo;
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
    @ApiLog(msg = "批量删除系统参数")
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<SystemParamDTO>> request) {
        List<SystemParamDTO> dtoList = request.getBody();
        try{
            Integer count = service.delete(dtoList);
            String msg = "成功删除了"+count+"个数据";
            return CommonResponseUtil.ok(msg,count.toString());
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_PARAM_DELETE_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "添加系统参数信息")
    public CommonResponse<Integer> insert(@Valid CommonRequest<SystemParamDTO> request) {
        SystemParamDTO dto = request.getBody();
        try{
            Integer res = service.insert(dto);
            if(res==-1){
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_PARAM_REPEAT_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_PARAM_INSERT_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "获取系统参数目录")
    public CommonResponse<List<SystemParamVO>> selectList(@Valid CommonRequest<SystemParamQuery> request) {
        SystemParamQuery query = request.getBody();
        try{
            List<SystemParamDTO> systemParamDTOList = service.selectByCondition(query);
            List<SystemParamVO> systemParamVOList = PojoUtils.copyListProperties(systemParamDTOList,SystemParamVO::new);
            return CommonResponseUtil.ok(systemParamVOList);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "搜索一个系统参数")
    public CommonResponse<SystemParamVO> select(@Valid CommonRequest<SystemParamQuery> request) {
        SystemParamQuery query = request.getBody();
        try{
            SystemParamDTO systemParamDTO = service.selectOne(query);
            SystemParamVO systemParamVO = new SystemParamVO();
            PojoUtils.copyProperties(systemParamDTO,systemParamVO);
            return CommonResponseUtil.ok(systemParamVO);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "更新系统参数信息")
    public CommonResponse<Integer> update(@Valid CommonRequest<SystemParamDTO> request) {
        SystemParamDTO dto = request.getBody();
        try{
            Integer res = service.update(dto);
            if(res==-1){
                //数据不存在无法更改
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_PARAM_UPDATE_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_PARAM_UPDATE_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "删除一条系统参数信息")
    public CommonResponse<Integer> delete(@Valid CommonRequest<SystemParamDTO> request) {
        SystemParamDTO dto = request.getBody();
        Integer res;
        try{
            res = service.delete(dto);
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_PARAM_DELETE_ERROR);
        }
    }

    /**
     * 分页条件搜索
     *
     * @param request
     * @return
     */
    @Override
    @ApiLog(msg = "分页条件搜索系统参数信息")
    public CommonResponse<CommonPage<SystemParamVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<SystemParamQuery>> request) {
        CommonPageRequest<SystemParamQuery> pageRequest = request.getBody();
        doBeforePagination(pageRequest.getPageNum(),pageRequest.getPageSize());
        try{
            List<SystemParamDTO> systemParamDTOList = service.selectByCondition(pageRequest.getQuery());
            List<SystemParamVO> systemParamVOList = PojoUtils.copyListProperties(systemParamDTOList,SystemParamVO::new);
            return buildPageResponse(new PageInfo<>(systemParamVOList));
        }catch (ServiceException e){
            log.info(e.getMessage(),e);
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR);
        }
    }
}
