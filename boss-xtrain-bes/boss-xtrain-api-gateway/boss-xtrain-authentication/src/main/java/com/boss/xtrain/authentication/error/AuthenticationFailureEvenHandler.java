package com.boss.xtrain.authentication.error;

import com.boss.xtrain.authentication.error.listener.AbstractAuthenticationFailureEvenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationFailureEvenHandler extends AbstractAuthenticationFailureEvenHandler {

    Logger log = LoggerFactory.getLogger(AuthenticationFailureEvenHandler.class);

    @Override
    public void handle(AuthenticationException authenticationException, Authentication authentication)
    {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        if (request != null) {
            String url = request.getRequestURI();
            String username = (String) authentication.getPrincipal();
            log.info("username：{} oauth fail：{}", username, url);
        }
    }
}
