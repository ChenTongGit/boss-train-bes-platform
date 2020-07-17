package com.boss.xtrain.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.boss.xtrain.authentication.dao")
@ComponentScan(basePackages = "com.boss.xtrain")
public class AuthenticationApplication {
    public static void main(String[] args){
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
