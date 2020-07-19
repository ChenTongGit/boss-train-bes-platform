package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.common.redis.config.RedisConfig;
import com.boss.xtrain.feign.interceptor.FeignClientInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import(RedisConfig.class)
public class OtherConfig {
    @Bean
    public FeignClientInterceptor getFeignClientInterceptor(){
        return new FeignClientInterceptor();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public FeignClientInterceptor feignClientInterceptor(){
        return new FeignClientInterceptor();
    }
}
