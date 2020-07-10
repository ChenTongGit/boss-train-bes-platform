package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.UserListVO;
import com.boss.xtrain.permission.api.UserApi;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:37 2020/07/09
 * @Description :user api实现
 * @Version: 1.0
 */
public class UserController implements UserApi {
    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<UserDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<UserDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<List<UserListVO>> selectList(@Valid CommonRequest<UserQueryDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<UserListVO> select(@Valid CommonRequest<UserQueryDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<UserDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> deletePatch(@Valid CommonRequest<List<UserDTO>> request) {
        return null;
    }
}
