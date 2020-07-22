package com.boss.xtrain.paper.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.boss.xtrain.paper")
@MapperScan("com.boss.xtrain.paper.mapper")
@EnableFeignClients(basePackages = "com.boss.xtrain")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
