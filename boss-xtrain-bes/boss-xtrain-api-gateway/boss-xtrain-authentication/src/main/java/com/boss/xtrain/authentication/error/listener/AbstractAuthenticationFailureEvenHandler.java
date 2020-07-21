package com.boss.xtrain.authentication.error.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public abstract class AbstractAuthenticationFailureEvenHandler implements  ApplicationListener<AbstractAuthenticationFailureEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event)
    {
        AuthenticationException authenticationException = event.getException();
        Authentication authentication = (Authentication) event.getSource();

        handle(authenticationException, authentication);
    }

    /**
     * 登录失败进行处理
     */
    public abstract void handle(AuthenticationException authenticationException, Authentication authentication);
}
