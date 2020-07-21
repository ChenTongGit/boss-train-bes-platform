package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;


@FrameworkEndpoint
public class RevokeTokenEndpoint {
    @Autowired
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    @PostMapping(value = "/oauth/logout")
    @ResponseBody
    public CommonResponse<String> revokeToken(@RequestParam String token) {
        CommonResponse<String> result = new CommonResponse();
        if (consumerTokenServices.revokeToken(token)) {
            result.setData("logout success");
        } else {
            result.setData("logout fail");
        }
        return result;
    }
}

