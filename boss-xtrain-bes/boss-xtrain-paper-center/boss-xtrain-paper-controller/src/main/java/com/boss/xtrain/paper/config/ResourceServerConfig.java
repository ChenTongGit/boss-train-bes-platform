package com.boss.xtrain.paper.config;

import com.boss.xtrain.feign.interceptor.FeignClientInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * <p> 配置资源服务器，对服务器的资源进行保护
 *
 * <p> 主要包含的功能配置：配置远程认证服务的地址、client id、client密码
 *
 * @author lzx
 * @version 0.0.1
 */
@Configuration
@EnableResourceServer
@Import(FeignClientInterceptor.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    // @Value("spring.security.resource.token-info-uri")
    private static final String tokenEndpointUrl = "http://localhost:18006/oauth/check_token";

    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;

    /**
     * 使用远程的认证服务，设置客户端信息，设置TokenConverter
     * @return ResourceServerTokenServices
     */
    @Primary
    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl(tokenEndpointUrl);
        remoteTokenServices.setClientId(oAuth2ClientProperties.getClientId());
        remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
        return remoteTokenServices;
    }

    /**
     * 配置默认的token翻译器
     * @return DefaultAccessTokenConverter
     */
    @Bean
    public AccessTokenConverter accessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }

    /**
     * Http安全配置，对每http请求链接进行校验
     *
     * 对 swagger等链接则不进行过滤
     * @param http HttpSecurity
     */

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //所有请求必须认证通过
        http.authorizeRequests()
            //下边的路径放行
            .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources",
                "/swagger-resources/configuration/security", "/swagger-ui.html","/webjars/**",
                "/course/coursepic/list/**")
            .permitAll()
            .anyRequest()
            .authenticated();
    }
}