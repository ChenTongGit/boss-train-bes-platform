package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.authentication.error.BesWebResponseExceptionTranslator;
import com.boss.xtrain.authentication.jwt.JwtTokenEnhancer;
import com.boss.xtrain.authentication.service.BesUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired
    DataSource dataSource;
    @Autowired
    private BesUserDetailService besUserDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    // 使用redis存储
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
    /*
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }*/
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("jwt_key");
        return accessTokenConverter;
    }
    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer() {
        return new JwtTokenEnhancer();
    }

    @Bean
    public WebResponseExceptionTranslator webResponseExceptionTranslator(){
        return new BesWebResponseExceptionTranslator();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
            .allowFormAuthenticationForClients()
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 这里只做password认证
        clients.inMemory()
            .withClient("bes")
            .scopes("read")
            .secret("12345")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token");
            /*
            .and()
            .withClient("webapp")
            .scopes("read")
            .authorizedGrantTypes("implicit")
            .and()
            .withClient("browser")
            .authorizedGrantTypes("refresh_token", "password")
            .scopes("read");*/
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer());
        delegates.add(jwtAccessTokenConverter());
        enhancerChain.setTokenEnhancers(delegates);

        endpoints
            .tokenStore(new RedisTokenStore(redisConnectionFactory))
            .userDetailsService(besUserDetailService)
            .authenticationManager(authenticationManager)
            .tokenServices(defaultTokenServices())
            .tokenEnhancer(enhancerChain)
            .exceptionTranslator(webResponseExceptionTranslator());
    }

    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        // token有效期自定义设置，默认12小时
        tokenServices.setAccessTokenValiditySeconds(60*60*12);
        // refresh_token默认30天
        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);
        return tokenServices;
    }

}
