package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

/**
 * <p> 定义注销登录时使用的endpoint </br>
 * </p>
 *
 * @author lzx
 * @date 2020.07.14
 * @version 1.0.0
 */
@FrameworkEndpoint
public class RevokeTokenEndpoint {
    @Autowired
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    /**
     * 解析jwt
     * @param token 用户当前token
     * @return 返回解析出来的信息
     */
    @PostMapping(value = "/oauth/logout")
    @ResponseBody
    public CommonResponse<String> revokeToken(@RequestParam String token) {
        CommonResponse<String> result = new CommonResponse<>();
        if (consumerTokenServices.revokeToken(token)) {
            result.setData("logout success");
        } else {
            result.setData("logout fail");
        }
        return result;
    }
}

