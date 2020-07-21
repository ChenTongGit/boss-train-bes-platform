package com.boss.xtrain.common.core.exception.handler;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.core.exception.error.AuthError;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws ServletException {
        Throwable cause = authException.getCause();

        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            if (cause instanceof InvalidTokenException) {
                // token错误时返回异常
                response.getWriter().write(JSON.toJSONString(CommonResponseUtil.error(
                    AuthError.INVALID_TOKEN_ERROR.getCode(), AuthError.INVALID_TOKEN_ERROR.getMessage()
                )));
            } else {
                // 没有token时返回异常
                response.getWriter().write(JSON.toJSONString(CommonResponseUtil.error(
                    AuthError.LOSSING_TOKEN_ERROR.getCode(), AuthError.LOSSING_TOKEN_ERROR.getMessage()
                )));
            }
        } catch (IOException e) {
            log.error("异常{}", e.toString());
        }
    }
}
