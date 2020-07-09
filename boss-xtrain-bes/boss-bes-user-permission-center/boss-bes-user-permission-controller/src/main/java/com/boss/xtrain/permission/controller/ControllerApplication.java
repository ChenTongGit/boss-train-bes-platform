package com.boss.xtrain.permission.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/*
 * @Author  :yushiqian
 * @Date    :20:19 2020/07/07
 * @Description :入口类，测试接口
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boss.xtrain.permission")
@MapperScan("com.boss.bes.permission.mapper")
public class ControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);
    }

}
