package com.boss.xtrain.common.core.http;

import com.boss.xtrain.common.core.constant.ResponseConstant;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.exception.error.SystemError;

/**
 * 响应封装工具类
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/4 7:09
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class CommonResponseUtil {

    private CommonResponseUtil(){}

    /**
     * 
     * @author ChenTong
     * @param msg
 * @param data
 * @param flag
     * @return com.boss.xtrain.common.core.http.CommonResponse<T>
     * @date 2020/7/4 13:26
     */
    public static <T> CommonResponse<T> ok(String msg, T data, Integer flag){
        return new CommonResponse<>(ResponseConstant.SUCCESS, msg, flag, data);
    }

    public static <T> CommonResponse<T> ok(String msg, T data){
        return new CommonResponse<>(ResponseConstant.SUCCESS, msg, data);
    }

    public static <T> CommonResponse<T> ok(T data){
        return new CommonResponse<>(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS_MSG, data);
    }

    public static <T> CommonResponse<T> ok(String code, String msg){
        return new CommonResponse<>(code, msg);
    }

    public static <T> CommonResponse<T> error(String code, String msg){
        return new CommonResponse<>(code, msg);
    }

    public static <T> CommonResponse<T> error(SystemError error){
        return new CommonResponse<>(error.getCode(), error.getMessage());
    }
    public static <T> CommonResponse<T> error(BusinessError error){
        return new CommonResponse<>(error.getCode(), error.getMessage());
    }


    public static <T> CommonResponse<T> warn(String code, String msg){
        return new CommonResponse<>(code, msg);
    }
}
