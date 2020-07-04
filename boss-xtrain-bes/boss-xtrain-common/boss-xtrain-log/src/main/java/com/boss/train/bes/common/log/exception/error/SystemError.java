package com.boss.train.bes.common.log.exception.error;

import lombok.Getter;
/**
 * @author 郭心蕊
 * @date 2020/07/01
 * @description 系统错误码设计
 */
@Getter
public enum SystemError {

    /**
     * 成功
     */
    SUCCESS("0","成功"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR("100100","系统异常"),
    /**
     * 网关服务系统错误码
     */
    GATEWAY_FORWARD_ERROR("100101", "转发失败"),

    GATEWAY_SERVICE_ERROR("100102", "调用鉴权服务失败"),

    /**
     * 认证/授权服务系统错误码
     */
    AUTHENTICATION_CREATE_TOKEN_ERROR("110101", "Token创建失败"),

    AUTHENTICATION_ERROR("110102", "认证失败"),

    AUTHENTICATION_SERVICE_ERROR("110103", "调用系统服务失败"),

    /**
     * 日志信息错误码
     */
    LOG_NOT_EXIST_ERROR("120101","请求的日志信息不存在"),

    LOG_OUTPUT_ERROR("120101","输出日志信息失败"),

    /**
     * CDN错误码
     */
    CDN_ERROR("130101", "CDN异常");

    private String code;
    private String message;

    SystemError(String code, String message){
        this.code = code;
        this.message = message;
    }
}

