package com.boss.xtrain.permission;

import com.boss.xtrain.common.core.constant.CommonConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 53534 秦昀清
 * @date 2020.07.07
 */
@SpringBootApplication
@MapperScan(basePackages = "com.boss.xtrain.permission.dao.mapper")
@ComponentScan(basePackages = "com.boss.xtrain.permission.*")
public class Application {

    /**
     * (scanBasePackages = {CommonConstant.BASE_PACKAGE},exclude = {DataSourceAutoConfiguration.class})
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
