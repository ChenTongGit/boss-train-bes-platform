package com.boss.train.bes.common.log.exception.resolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalExceptionConfig {

    @Bean
    public GlobalExceptionResolver globalExceptionHandler(){
        return new GlobalExceptionResolver();
    }
}
