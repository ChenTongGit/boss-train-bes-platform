package com.boss.xtrain.exam;

import com.boss.xtrain.common.core.constant.CommonConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 考试中心微服务 naco客户端
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/23 15:39
 * @copyright
 * @modified
 * @see
 * @since
 **/
@SpringBootApplication(scanBasePackages = { CommonConstant.BASE_PACKAGE })
@MapperScan("com.boss.xtrain.exam.dao.mapper")
@EnableFeignClients
public class ExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }
}
