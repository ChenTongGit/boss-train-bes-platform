package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
=======
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
>>>>>>> dev0.1
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {CommonConstant.BASE_PACKAGE})
@MapperScan("com.boss.xtrain.basedata.mapper")
<<<<<<< HEAD
@EnableFeignClients
=======
@EnableDiscoveryClient
>>>>>>> dev0.1
public class ControllerApplication {
    public static void main(String[] args){
        SpringApplication.run(ControllerApplication.class,args);
    }
}
