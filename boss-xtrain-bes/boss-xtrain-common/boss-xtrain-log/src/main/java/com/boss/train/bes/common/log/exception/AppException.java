package com.boss.train.bes.common.log.exception;

import com.boss.train.bes.common.log.exception.error.BusinessError;
import com.boss.train.bes.common.log.exception.error.SystemError;

public class AppException extends RuntimeException {
    private String code;
    private String message;

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
