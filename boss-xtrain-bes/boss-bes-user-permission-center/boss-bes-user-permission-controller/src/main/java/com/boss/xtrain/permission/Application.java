package com.boss.xtrain.permission;

import com.boss.xtrain.common.core.constant.CommonConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 53534 秦昀清
 * @date 2020.07.07
 */
@SpringBootApplication(scanBasePackages = {CommonConstant.BASE_PACKAGE})
@MapperScan(basePackages = "com.boss.xtrain.permission.mapper")
@EnableDiscoveryClient
public class Application {
    /**
     * (scanBasePackages = {CommonConstant.BASE_PACKAGE},exclude = {DataSourceAutoConfiguration.class})
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
