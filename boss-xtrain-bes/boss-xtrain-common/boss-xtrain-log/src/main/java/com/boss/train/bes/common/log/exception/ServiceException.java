package com.boss.train.bes.common.log.exception;

import com.boss.train.bes.common.log.exception.error.BusinessError;
import com.boss.train.bes.common.log.exception.error.SystemError;

import java.io.Serializable;

public class ServiceException extends AppException implements Serializable {
    /**
     * 服务异常 业务错误
     *
     * @param businessError
     */
    public ServiceException(BusinessError businessError){
        super(businessError);
    }

    /**
     * 服务异常 业务错误 异常堆栈信息
     *
     * @param businessError
     * @param cause
     */
    public ServiceException(BusinessError businessError, Throwable cause){
        super(businessError,cause);
    }

    /**
     * 服务异常 系统错误
     *
     * @param systemError
     */
    public ServiceException(SystemError systemError){
        super(systemError);
    }

    /**
     * 服务异常 系统错误 异常堆栈信息
     *
     * @param systemError
     * @param cause
     */
    public ServiceException(SystemError systemError, Throwable cause){
        super(systemError,cause);
    }
}
