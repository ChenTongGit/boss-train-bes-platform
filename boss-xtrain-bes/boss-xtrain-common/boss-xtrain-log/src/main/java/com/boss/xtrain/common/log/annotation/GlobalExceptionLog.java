package com.boss.xtrain.common.log.annotation;

import java.lang.annotation.*;

/**
 * @author 郭心蕊
 * @date 2020/07/03
 * @description 统一异常注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalExceptionLog {

    /**
     * 设置日志基本内容
     * @return {String}
     */
    String value() default "";
}
