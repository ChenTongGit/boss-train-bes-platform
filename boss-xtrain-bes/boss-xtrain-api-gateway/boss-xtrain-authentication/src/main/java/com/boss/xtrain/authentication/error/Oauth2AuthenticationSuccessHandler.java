package com.boss.xtrain.authentication.error;

import com.boss.xtrain.authentication.jwt.UserJwt;
import com.boss.xtrain.common.redis.api.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证成功的事件会在这里被捕获
 *
 * @author lzx
 * @version 1.0.0
 */
@Slf4j
@Component("authSuccessHandle")
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {
        log.info("认证成功");
        UserJwt userJwt = (UserJwt) authentication.getPrincipal();
        redisUtil.set("bes:effectentity:" + userJwt.getId(), userJwt);
    }
}
