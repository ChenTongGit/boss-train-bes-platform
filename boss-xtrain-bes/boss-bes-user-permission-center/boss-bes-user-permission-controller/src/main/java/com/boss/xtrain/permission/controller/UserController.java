package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.api.UserApi;
import com.boss.xtrain.permission.pojo.dto.ExamServiceUsersDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import com.boss.xtrain.permission.pojo.vo.UserListVO;
import com.boss.xtrain.permission.service.UserSerivce;
import lombok.extern.slf4j.Slf4j;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:37 2020/07/09
 * @Description :user api实现
 * @Version: 1.0
 */
@RestController
@Slf4j
public class UserController extends BaseController implements UserApi {

    @Autowired
    UserSerivce userSerivce;

    public CommonResponse<Integer> insert(@Valid CommonRequest<UserDTO> request) {
        UserDTO userDTO = request.getBody();
        log.info(userDTO.toString());
        int row = userSerivce.insert(userDTO);
        return CommonResponseUtil.ok(row);
    }

    public CommonResponse<Integer> delete(@Valid CommonRequest<UserDTO> request) {
        return CommonResponseUtil.ok(userSerivce.delete(request.getBody()));
    }

    public CommonResponse<List<UserListVO>> selectList(@Valid CommonRequest<UserQueryDTO> request) {
        UserQueryDTO queryDTO = request.getBody();
        List<UserDTO> userDTOS = userSerivce.selectByCondition(queryDTO);
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(userDTOS,UserListVO::new));
    }

    public CommonResponse<UserListVO> select(@Valid CommonRequest<UserQueryDTO> request) {
        UserQueryDTO queryDTO = request.getBody();
        UserDTO userDTO = userSerivce.select(queryDTO);
        UserListVO vo = new UserListVO();
        PojoUtils.copyProperties(userDTO,vo);
        return CommonResponseUtil.ok(vo);
    }

    public CommonResponse<Integer> update(@Valid CommonRequest<UserDTO> request) {
        log.info(request.getBody().toString());
        return CommonResponseUtil.ok(userSerivce.update(request.getBody()));
    }

    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<UserDTO>> request) {
        List<UserDTO> userDTOS  = request.getBody();
        return CommonResponseUtil.ok(userSerivce.delete(userDTOS));
    }

    public CommonResponse<List<UserListVO>> selectAllUser(){
        List<UserDTO> userDTOS = userSerivce.selectAll();
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(userDTOS,UserListVO::new));
    }

    public CommonResponse<List<RoleListVO>> getAllRole(@Valid CommonRequest<UserQueryDTO> request) {
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(userSerivce.getAllRoles(request.getBody()),RoleListVO::new));
    }

    public CommonResponse<List<ResourceListVO>> getAllResource(@Valid CommonRequest<RoleQueryDTO> request) {
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(userSerivce.getAllResource(request.getBody()),ResourceListVO::new));
    }

    @Override
    public CommonResponse<CommonPage<UserListVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<UserQueryDTO>> request) {
        Page<Object> page =  doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<UserDTO> userDTOS = userSerivce.selectByCondition(request.getBody().getQuery());
        List<UserListVO> userListVOS = PojoUtils.copyListProperties(userDTOS,UserListVO::new);
        return buildPageResponse(page,userListVOS);
    }

    @Override
    public CommonResponse<CommonPage<UserListVO>> selectAllByPage(@Valid CommonRequest<CommonPageRequest> request) {
        Page<Object> page =  doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        log.info(page.toString());
        List<UserDTO> userDTOList = userSerivce.selectAll();
        List<UserListVO> userVOList = PojoUtils.copyListProperties(userDTOList, UserListVO::new);
        return buildPageResponse(page,userVOList);
    }

    @Override
    public CommonResponse<Boolean> allocateRole(@Valid CommonRequest<List<UserRoleDTO>> request) {
        List<UserRoleDTO> userRoleDTOS = request.getBody();
        boolean result = userSerivce.allocateRole(userRoleDTOS);
        return CommonResponseUtil.ok(result);
    }

    @Override
    public CommonResponse<List<RoleListVO>> getRoles(@Valid CommonRequest<UserQueryDTO> request) {
        UserQueryDTO queryDTO = request.getBody();
        List<RoleDTO> roleDTOS = userSerivce.getRoles(queryDTO);
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(roleDTOS,RoleListVO::new));
    }

    /**
     * 考试服务消费接口
     * @author ChenTong
     * @param request 
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.util.List<com.boss.xtrain.permission.pojo.dto.ExamServiceUsersDTO>>
     * @date 2020/7/20 12:21
     */
    @Override
    public CommonResponse<List<ExamServiceUsersDTO>> getUserByPosition(@Valid CommonRequest<UserQueryDTO> request) {
        UserQueryDTO queryDTO = request.getBody();
        List<ExamServiceUsersDTO> userDTOS = userSerivce.getUserByPosition(queryDTO);
        return CommonResponseUtil.ok(userDTOS);
    }
}
