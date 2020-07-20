package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.authentication.filter.UserInfoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CustomWebMvcConfig  extends WebMvcConfigurationSupport {
    /**
     * 注册用户信息拦截器
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInfoInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}