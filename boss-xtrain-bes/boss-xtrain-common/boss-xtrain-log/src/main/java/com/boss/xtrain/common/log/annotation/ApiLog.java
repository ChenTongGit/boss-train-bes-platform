package com.boss.xtrain.common.log.annotation;


import java.lang.annotation.*;

/**
 * @author 郭心蕊
 * @date 2020/07/01
 * @description 自定义日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiLog {
    /**
     * 描述
     * @return {String}
     */
    String msg() default "";
}
