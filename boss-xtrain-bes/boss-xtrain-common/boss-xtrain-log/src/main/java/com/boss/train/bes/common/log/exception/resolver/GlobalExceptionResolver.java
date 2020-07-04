package com.boss.train.bes.common.log.exception.resolver;

import com.boss.train.bes.common.log.exception.AppException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionResolver {
  /*

@ExceptionHandler(value = SystemException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse handlerSystemException(SystemException e) {
        outPutError(SystemException.class, SystemError.SYSTEM_ERROR, e.getCause());
        return CommonResponse.error(e.getCode(), e.getMessage());
    }

    public CommonResponse handleException(Exception e) {
       if (e instanceof ClientException) {
            return handlerClientException((ClientException) cause);
        }
        if (e instanceof FeignException) {
            return handlerFeignException((FeignException) cause);
        }
        if (e instanceof MyBatisSystemException) {
            return handlerMyBatisSystemException((MyBatisSystemException) cause);
        }
        if (e instanceof DataIntegrityViolationException) {
            return handlerDataIntegrityViolationException((DataIntegrityViolationException) cause);
        }
        if (e instanceof NullPointerException) {
            return handlerNullPointerException((NullPointerException) cause);
        }
        return CommonResponse.;

   }*/

}

