package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.authentication.jwt.UserJwt;
import com.boss.xtrain.common.redis.api.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component("authSuccessHandle")
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("认证成功");
        User user = (User) authentication.getPrincipal();
        if (user != null) {
            log.info(user.toString());
        }
        assert user != null;
        redisUtil.set("bes:effectentity:" + user.getUsername(), user);
        response.sendRedirect("/index");
    }
}
