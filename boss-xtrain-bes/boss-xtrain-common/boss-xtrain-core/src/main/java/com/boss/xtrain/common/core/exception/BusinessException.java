package com.boss.xtrain.common.core.exception;

import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.exception.error.SystemError;

import java.io.Serializable;

/**
 * @author 郭心蕊
 * @date 2020/07/01
 * @description 业务异常
 */
public class BusinessException extends AppException implements Serializable {

    /**
     * 业务异常 系统错误
     *
     * @param systemError
     */
    public BusinessException(SystemError systemError) {
        super(systemError);
    }

    /**
     * 业务异常 系统错误 异常堆栈信息
     *
     * @param systemError
     * @param cause
     */
    public BusinessException(SystemError systemError, Throwable cause){
        super(systemError, cause);
    }

    /**
     * 业务异常 业务错误
     *
     * @param businessError
     */
    public BusinessException(BusinessError businessError) {
        super(businessError);
    }

    /**
     * 业务异常 业务错误 异常堆栈信息
     *
     * @param businessError
     * @param cause
     */
    public BusinessException(BusinessError businessError, Throwable cause){
        super(businessError, cause);
    }


    public BusinessException(String code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
