package com.boss.xtrain.authentication.error;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败的事件会在这里被捕获
 *
 * @author lzx
 * @version 1.0.0
 */
@Component("authFailureHandle")
public class Oauth2AuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response,
        AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(CommonResponseUtil.ok("500404", exception.getMessage())));
    }
}