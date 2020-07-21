package com.boss.xtrain.common.core.exception.handler;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.core.exception.error.AuthError;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("customAccessDeniedHandler")
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
        throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSON.toJSONString(CommonResponseUtil.error(
                AuthError.ACCESS_DENIED_ERROR.getCode(), AuthError.ACCESS_DENIED_ERROR.getMessage()
            )));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}