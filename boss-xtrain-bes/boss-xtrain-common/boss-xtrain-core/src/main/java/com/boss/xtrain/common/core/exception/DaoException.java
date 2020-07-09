package com.boss.xtrain.common.core.exception;

import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.exception.error.DaoError;
import com.boss.xtrain.common.core.exception.error.SystemError;

import java.io.Serializable;

/**
 * @author 郭心蕊
 * @date 2020/07/02
 * @description Dao异常
 */
public class DaoException extends AppException implements Serializable {

    /**
     * 服务异常 业务错误
     *
     * @param businessError
     */
    public DaoException(BusinessError businessError){
        super(businessError);
    }

    public DaoException(DaoError daoError){
        super(daoError);
    }

    public DaoException(DaoError daoError , Throwable cause){
        super(daoError, cause);
    }

    /**
     * 服务异常 业务错误 异常堆栈信息
     *
     * @param businessError
     * @param cause
     */
    public DaoException(BusinessError businessError, Throwable cause){
        super(businessError,cause);
    }

    /**
     * 服务异常 系统错误
     *
     * @param systemError
     */
    public DaoException(SystemError systemError){
        super(systemError);
    }

    /**
     * 服务异常 系统错误 异常堆栈信息
     *
     * @param systemError
     * @param cause
     */
    public DaoException(SystemError systemError, Throwable cause){
        super(systemError,cause);
    }
}
