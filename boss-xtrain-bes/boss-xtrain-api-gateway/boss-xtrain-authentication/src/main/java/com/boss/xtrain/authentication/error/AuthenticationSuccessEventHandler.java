package com.boss.xtrain.authentication.error;

import com.boss.xtrain.authentication.error.listener.AbstractAuthenticationSuccessEventHandler;
import com.boss.xtrain.authentication.jwt.UserJwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationSuccessEventHandler extends AbstractAuthenticationSuccessEventHandler {

    Logger log = LoggerFactory.getLogger(AuthenticationSuccessEventHandler.class);

    @Override
    public void handle(Authentication authentication)
    {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String url = request.getRequestURI();
        if (authentication.getPrincipal() instanceof UserJwt)
        {
            UserJwt user = (UserJwt) authentication.getPrincipal();
            String username = user.getUsername();
            log.info("username：{} 授权成功：{}", username, url);
        }
    }
}
