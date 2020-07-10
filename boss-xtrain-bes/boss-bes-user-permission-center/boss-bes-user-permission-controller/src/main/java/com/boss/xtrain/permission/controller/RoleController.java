package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import com.boss.xtrain.permission.service.RoleService;
import com.boss.xtrain.permission.api.RoleApi;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleController implements RoleApi {

    @Autowired
    private RoleService roleService;

    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<RoleDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<RoleDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<List<RoleListVO>> selectList(@Valid CommonRequest<ResourceQueryDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<RoleListVO> select(@Valid CommonRequest<ResourceQueryDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<RoleDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> deletePatch(@Valid CommonRequest<List<RoleDTO>> request) {
        return null;
    }
}
