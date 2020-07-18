package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.authentication.jwt.UserJwt;
import com.boss.xtrain.common.redis.api.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    public Oauth2AuthenticationSuccessHandler() {
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        UserJwt userJwt = (UserJwt) authentication.getPrincipal();
        if (userJwt != null) {
            log.info(userJwt.toString());
        }
        redisUtil.set("bes：effectentity：userid", userJwt);
    }
}
