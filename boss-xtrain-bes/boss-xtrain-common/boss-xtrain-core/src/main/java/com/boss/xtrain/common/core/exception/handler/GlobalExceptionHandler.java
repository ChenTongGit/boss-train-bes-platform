package com.boss.xtrain.common.core.exception.handler;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.redis.api.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler implements ResponseBodyAdvice {

    @Autowired
    private RedisUtil redisUtil;

    private ThreadLocal<Object> modelHolder = new ThreadLocal<>();

    //参数验证失败，抛出异常处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse handleIllegalParamException(MethodArgumentNotValidException e) {
        log.error(e.getLocalizedMessage(),e);
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (!errors.isEmpty()) {
            tips = errors.get(0).getDefaultMessage();
        }

        return CommonResponseUtil.error(SystemError.VALID_ERROR.getCode(),tips);
    }

    //BusinessException处理
    @ExceptionHandler(BusinessException.class)
    public CommonResponse handleResultException(BusinessException e, HttpServletRequest request) {

        log.debug("uri={} | requestBody={}", request.getRequestURI(),
                JSON.toJSONString(modelHolder.get()));
        return CommonResponseUtil.error(e.getCode(), e.getMessage());
    }


    //处理Exception异常
    @ExceptionHandler(Exception.class)
    public CommonResponse handleException(Exception e, HttpServletRequest request) {
        log.error("uri={} | requestBody={}", request.getRequestURI(),
                JSON.toJSONString(modelHolder.get()), e);
        return CommonResponseUtil.error(SystemError.WEAK_NET_WORK.getCode(),e.getLocalizedMessage());
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // ModelHolder 初始化
        modelHolder.set(webDataBinder.getTarget());
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // ModelHolder 清理
        modelHolder.remove();
        return body;
    }

}

