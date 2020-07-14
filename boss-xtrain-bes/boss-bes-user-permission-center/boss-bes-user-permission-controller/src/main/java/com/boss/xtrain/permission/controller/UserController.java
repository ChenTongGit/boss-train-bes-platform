package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.UserListVO;
import com.boss.xtrain.permission.api.UserApi;
import com.boss.xtrain.permission.service.UserSerivce;
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
public class UserController implements UserApi {

    @Autowired
    UserSerivce userSerivce;

    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<UserDTO> request) {
        UserDTO userDTO = request.getBody();
        int row = userSerivce.insert(userDTO);
        return CommonResponseUtil.ok(row);
    }

    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<UserDTO> request) {
        return CommonResponseUtil.ok(userSerivce.delete(request.getBody()));
    }

    @Override
    public CommonResponse<List<UserListVO>> selectList(@Valid CommonRequest<UserQueryDTO> request) {
        UserQueryDTO queryDTO = request.getBody();
        List<UserDTO> userDTOS = userSerivce.selectByCondition(queryDTO);
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(userDTOS,UserListVO::new));
    }

    @Override
    public CommonResponse<UserListVO> select(@Valid CommonRequest<UserQueryDTO> request) {
        UserQueryDTO queryDTO = request.getBody();
        UserDTO userDTO = userSerivce.select(queryDTO);
        UserListVO vo = new UserListVO();
        PojoUtils.copyProperties(userDTO,vo);
        return CommonResponseUtil.ok(vo);
    }

    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<UserDTO> request) {
        return CommonResponseUtil.ok(userSerivce.update(request.getBody()));
    }

    @Override
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<UserDTO>> request) {
        List<UserDTO> userDTOS  = request.getBody();
        return CommonResponseUtil.ok(userSerivce.delete(userDTOS));
    }

    @Override
    public CommonResponse<List<UserListVO>> selectAllUser(){
        List<UserDTO> userDTOS = userSerivce.selectAll();
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(userDTOS,UserListVO::new));
    }
}
