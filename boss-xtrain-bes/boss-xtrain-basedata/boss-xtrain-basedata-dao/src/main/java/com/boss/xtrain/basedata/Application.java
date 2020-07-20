package com.boss.xtrain.basedata;

import com.boss.xtrain.common.core.constant.CommonConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {CommonConstant.BASE_PACKAGE})
@MapperScan("com.boss.xtrain.basedata.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
