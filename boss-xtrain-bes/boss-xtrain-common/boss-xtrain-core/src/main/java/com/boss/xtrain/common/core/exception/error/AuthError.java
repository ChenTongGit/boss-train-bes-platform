package com.boss.xtrain.common.core.exception.error;

import lombok.Getter;

/**
 * @author lzx
 * @date 2020/07/20
 * @description 认证错误码设计
 */

@Getter
public enum AuthError {
    INVALID_TOKEN_ERROR ("500401", "Token 错误"),
    LOSSING_TOKEN_ERROR ("500402", "Token 丢失"),
    ACCESS_DENIED_ERROR ("500403", "拒绝访问");

    /**
     * 异常码
     */
    private String code;
    /**
     * 异常信息
     */
    private String message;
    AuthError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
