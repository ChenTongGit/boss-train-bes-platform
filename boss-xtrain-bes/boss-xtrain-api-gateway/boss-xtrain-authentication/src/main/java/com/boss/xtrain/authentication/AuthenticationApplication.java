package com.boss.xtrain.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 程序启动入口
 *
 * @author lzx
 * @version 1.0.0
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.boss.xtrain")
public class AuthenticationApplication {
    public static void main(String[] args){
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
