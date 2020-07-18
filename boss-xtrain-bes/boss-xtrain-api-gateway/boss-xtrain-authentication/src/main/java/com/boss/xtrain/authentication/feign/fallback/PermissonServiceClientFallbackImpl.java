package com.boss.xtrain.authentication.feign.fallback;

import com.boss.xtrain.authentication.constant.ClientConstant;
import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户服务断路器实现
 *
 */
@Slf4j
@Component
public class PermissonServiceClientFallbackImpl implements PermissonServiceClient {

    private Throwable throwable;

    /**
     * 根据用户名查询用户信息
     *
     * @return ResponseBean
     */
    @Override
    public CommonResponse<UserDTO> findUserByName(@RequestBody @Valid CommonRequest<UserQueryDTO> request){
        log.error("服务降级返回", throwable);
        return null;
    }

    @Override
    public CommonResponse<List<RoleListVO>> findRoleByName(@RequestBody @Valid CommonRequest<UserQueryDTO> request){
        log.error("服务降级返回", throwable);
        return null;
    }

    @Override
    public CommonResponse<List<ResourceListVO>> findResourceByName(@RequestBody @Valid CommonRequest<RoleQueryDTO> request){
        log.error("服务降级返回", throwable);
        return null;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
