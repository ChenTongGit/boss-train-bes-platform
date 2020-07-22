package com.boss.xtrain.permission.controller;

import com.alibaba.fastjson.JSONObject;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;

import com.boss.xtrain.common.util.JwtUtils;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.vo.PositionListVO;
import com.boss.xtrain.permission.service.PositionService;
import com.boss.xtrain.permission.api.PositionApi;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:59 2020/07/07
 * @Description :controller类设计
 * @Version: 1.0
 */

@RestController
@Slf4j
@Api(tags = {"职位管理"})
public class PositionController extends BaseController implements PositionApi {

    @Autowired
    private PositionService positionService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @ApiOperation("新增职位")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('position_admin')")
    public CommonResponse<Integer> insert(@Valid CommonRequest<PositionDTO> request) {
        PositionDTO dto = request.getBody();
        RequestAttributes attribute = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)attribute;
        HttpServletRequest servletRequest = servletRequestAttributes.getRequest();
        String token = servletRequest.getHeader("Authorization");
        //String token = request.getHeader().getToken();
        String parseToken = token.split(" ")[1];
        log.info("token:"+token);
        String json = JwtUtils.getParseToken(parseToken);
        Long createdBy = ((Number)JSONObject.parseObject(json).get("id")).longValue();
        log.info("createBy:"+createdBy.toString());
        dto.setCreatedBy(createdBy);
        log.info(dto.toString());
        return CommonResponseUtil.ok(positionService.insert(dto));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('position_admin')")
    public CommonResponse<Integer> delete(@Valid CommonRequest<PositionDTO> request) {
        PositionDTO body = request.getBody();
        return CommonResponseUtil.ok(positionService.delete(body));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('position_admin')")
    public CommonResponse<List<PositionListVO>> selectList(@Valid CommonRequest<PositionQueryDTO> request) {
        PositionQueryDTO query = request.getBody();
        List<PositionDTO> positionDTOS = positionService.selectByCondition(query);
        List<PositionListVO> listVOS = PojoUtils.copyListProperties(positionDTOS,PositionListVO::new);
        return CommonResponseUtil.ok(listVOS);
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('position_admin')")
    public CommonResponse<PositionListVO> select(@Valid CommonRequest<PositionQueryDTO> request) {
        return null;
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('position_admin')")
    public CommonResponse<Integer> update(@Valid CommonRequest<PositionDTO> request) {
        PositionDTO dto = request.getBody();
        RequestAttributes attribute = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)attribute;
        HttpServletRequest servletRequest = servletRequestAttributes.getRequest();
        String token = servletRequest.getHeader("Authorization");
        //String token = request.getHeader().getToken();
        String parseToken = token.split(" ")[1];
        log.info("token:"+token);
        String json = JwtUtils.getParseToken(parseToken);
        Long updateBy = ((Number)JSONObject.parseObject(json).get("id")).longValue();
        log.info("updateBy:"+updateBy.toString());
        dto.setUpdatedBy(updateBy);
        log.info(dto.toString());
        return CommonResponseUtil.ok(positionService.update(dto));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('position_admin')")
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<PositionDTO>> request) {
        List<PositionDTO> body = request.getBody();
        return CommonResponseUtil.ok(positionService.delete(body));

    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('position_admin')")
    public CommonResponse<List<PositionListVO>> selectAllPosition() {
//       PositionQueryDTO query = request.getBody();
//       List<PositionDTO> positionDTOS = positionService.selectAll(query);
//       List<PositionListVO> positionListVOS = PojoUtils.copyListProperties(positionDTOS,PositionListVO::new);
//       return CommonResponseUtil.ok(positionListVOS);
        log.info("getAll");
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(positionService.selectAll(),PositionListVO::new));
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('position_admin')")
    public CommonResponse<CommonPage<PositionListVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<PositionQueryDTO>> request) {
        Page<Object> page =  doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        log.info(request.getBody().getQuery().toString());
        List<PositionDTO> positionDTOS = positionService.selectByCondition(request.getBody().getQuery());
        List<PositionListVO> positionListVOS = PojoUtils.copyListProperties(positionDTOS,PositionListVO::new);
        return buildPageResponse(page,positionListVOS);
    }

    @Override
    public CommonResponse<CommonPage<PositionListVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest> request){
        Page<Object> page =  doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        log.info(page.toString());
        List<PositionDTO> positionDTOList = positionService.selectAll();
        List<PositionListVO> positionVOList = PojoUtils.copyListProperties(positionDTOList, PositionListVO::new);
        return buildPageResponse(page,positionVOList);
    }
}
