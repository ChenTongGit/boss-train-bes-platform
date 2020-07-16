package com.boss.xtrain.authentication.feign;

import com.boss.xtrain.authentication.constant.ClientConstant;
import com.boss.xtrain.authentication.feign.factory.PermissonServiceClientFallbackFactory;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户服务
 */
@FeignClient(name = ClientConstant.USER_SERVICE_NAME, fallbackFactory = PermissonServiceClientFallbackFactory.class)
public interface PermissonServiceClient {

    /**
     * 根据用户名获取用户详细信息
     *
     * @param request 用户标识
     * @return ResponseBean
     */
    @PostMapping("/education/bes/v1/user/select")
    CommonResponse<UserDTO> findUserByName(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    @PostMapping("/education/bes/v1/role/select")
    CommonResponse<List<RoleListVO>> findRoleByName(@RequestBody @Valid CommonRequest<RoleQueryDTO> request);

    @PostMapping("/education/bes/v1/resource/select")
    CommonResponse<List<ResourceListVO>> findResourceByName(@RequestBody @Valid CommonRequest<ResourceQueryDTO> request);
}
