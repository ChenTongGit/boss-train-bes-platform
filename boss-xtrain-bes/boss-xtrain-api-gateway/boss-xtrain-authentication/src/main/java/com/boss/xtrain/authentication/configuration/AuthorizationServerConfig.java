package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.authentication.jwt.JwtTokenEnhancer;
import com.boss.xtrain.authentication.serializer.JacksonSerializationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p> 配置认证服务器 <br>
 * 包括指定使用redis存储token、Jwt加密方式、异常翻译器等 <br>
 *  多个资源服务器可以使用一个认证服务器
 * </p>
 *
 * @author lzx
 * @date 2020.07.13
 * @version 1.0.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private BesAccessTokenConverter besAccessTokenConverter;
    @Autowired
    private EncryptPasswordEncoder encryptPasswordEncoder;

    // 使用redis存储
    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore store = new RedisTokenStore(redisConnectionFactory);
        store.setSerializationStrategy(new JacksonSerializationStrategy());
        return store;
    }

    /**
     * 配置客户端信息
     * @param clients 客户端配置
     * @throws Exception 抛出异常
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 这里只做password认证
        clients.inMemory()
            .withClient("bes")
            .scopes("read", "write")
            .secret("12345")
            .authorizedGrantTypes("password", "refresh_token");
    }

    /**
     * 配置用户服务
     * @param endpoints 认证端点配置
     * @throws Exception 抛出异常
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer());
        delegates.add(jwtAccessTokenConverter());
        enhancerChain.setTokenEnhancers(delegates);
        endpoints
            .tokenEnhancer(enhancerChain)
            .authenticationManager(authenticationManager)
            .tokenStore(tokenStore());

        DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints
            .getDefaultAuthorizationServerTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        // 指定有效时间为一天
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1));
        endpoints.tokenServices(tokenServices);
        super.configure(endpoints);
    }

    /**
     * 配置jwt翻译器，加载密钥信息
     * @return 返回加载了密钥和加密方式的翻译器
     */
    @Bean
    public TokenEnhancer jwtAccessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyStoreKeyFactory keyStoreKeyFactory =
            new KeyStoreKeyFactory(new ClassPathResource("bes-jwt.jks"), "123456".toCharArray());
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("bes-jwt"));
        converter.setAccessTokenConverter(besAccessTokenConverter);
        return converter;
    }

    /**
     * 配置自定义的token信息扩展器
     * @return 返回bean
     */
    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer() {
        return new JwtTokenEnhancer();
    }

    /**
     * 配置认证服务器的路径和密码加密方式等
     * @param security
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
            .allowFormAuthenticationForClients()
            .passwordEncoder(encryptPasswordEncoder)
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("permitAll()");
    }
}
