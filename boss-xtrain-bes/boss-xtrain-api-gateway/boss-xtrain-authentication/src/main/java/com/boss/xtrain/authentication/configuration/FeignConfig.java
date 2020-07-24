package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.common.redis.config.RedisConfig;
import com.boss.xtrain.feign.interceptor.FeignClientInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

/**
 * <p> 配置注入其它一些必要的bean <br>
 * </p>
 * @author lzx
 * @date 2020.07
 * @version 1.0.0
 */
@Configuration
@Import({RedisConfig.class})
public class FeignConfig {
    /**
     * 注入Feign拦截器
     * @return 返回拦截器
     */
    @Bean
    public FeignClientInterceptor getFeignClientInterceptor(){
        return new FeignClientInterceptor();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
