package com.boss.xtrain.common.core.exception;

import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.exception.error.DaoError;
import com.boss.xtrain.common.core.exception.error.SystemError;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final String code;
    private final String message;

    public AppException(){
        this.code = null;
        this.message = null;
    }

    public AppException(String code, String message){
        this.code = code;
        this.message = message;
    }

    public AppException(String code, String message, Throwable throwable){
        super(throwable);
        this.code = code;
        this.message = message;
    }

    public AppException(SystemError systemError) {
        this.code = systemError.getCode();
        this.message = systemError.getMessage();
    }

    public AppException(DaoError daoError) {
        this.code = daoError.getCode();
        this.message = daoError.getMessage();
    }

    public AppException(DaoError daoError, Throwable throwable) {
        super(throwable);
        this.code = daoError.getCode();
        this.message = daoError.getMessage();
    }

    public AppException(SystemError systemError, Throwable throwable) {
        super(throwable);
        this.code = systemError.getCode();
        this.message = systemError.getMessage();
    }

    public AppException(BusinessError businessError) {
        this.code = businessError.getCode();
        this.message = businessError.getMessage();
    }

    public AppException(BusinessError businessError, Throwable throwable) {
        super(throwable);
        this.code = businessError.getCode();
        this.message = businessError.getMessage();
    }
}
