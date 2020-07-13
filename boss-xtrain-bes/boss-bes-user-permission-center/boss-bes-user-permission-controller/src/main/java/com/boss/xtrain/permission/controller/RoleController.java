package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
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
        RoleDTO roleDTO = request.getBody();
        return CommonResponseUtil.ok(roleService.insert(roleDTO));
    }

    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<RoleDTO> request) {
        RoleDTO roleDTO = new RoleDTO();
        return CommonResponseUtil.ok(roleService.delete(roleDTO));
    }

    @Override
    public CommonResponse<List<RoleListVO>> selectList(@Valid CommonRequest<RoleQueryDTO> request) {
        RoleQueryDTO queryDTO = request.getBody();
        List<RoleDTO> roleDTOS = roleService.selectByCondition(queryDTO);
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(roleDTOS,RoleListVO::new));
    }

    @Override
    public CommonResponse<RoleListVO> select(@Valid CommonRequest<RoleQueryDTO> request) {
        RoleQueryDTO queryDTO = request.getBody();
        RoleDTO result = roleService.selectByCondition(queryDTO).get(0);
        RoleListVO vo = new RoleListVO();
        PojoUtils.copyProperties(result,vo);
        return CommonResponseUtil.ok(vo);
    }

    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<RoleDTO> request) {
        return CommonResponseUtil.ok(roleService.update(request.getBody()));
    }

    @Override
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<RoleDTO>> request) {
        return CommonResponseUtil.ok(roleService.delete(request.getBody()));
    }

    @Override
    public CommonResponse<List<RoleListVO>> selectAllRole(){
        List<RoleDTO> roleDTOS = roleService.selectAll();
        return CommonResponseUtil.ok(PojoUtils.copyListProperties(roleDTOS,RoleListVO::new));
    }
}
