package com.boss.xtrain.common.core.http;

import com.boss.xtrain.common.core.constant.ResponseConstant;

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

    public static <T> CommonResponse<T> ok(String msg, T data, Integer flag){
        return new CommonResponse<>(ResponseConstant.SUCCESS, msg, flag, data);
    }

    public static <T> CommonResponse<T> ok(String msg, T data){
        return new CommonResponse<>(ResponseConstant.SUCCESS, msg, data);
    }

    public static <T> CommonResponse<T> ok(T data){
        return new CommonResponse<>(ResponseConstant.SUCCESS, ResponseConstant.SUCCESS_MSG, data);
    }

    public static <T> CommonResponse<T> ok(Integer code, String msg){
        return new CommonResponse<>(code, msg);
    }

    public static <T> CommonResponse<T> error(Integer code, String msg){
        return new CommonResponse<>(code, msg);
    }

    public static <T> CommonResponse<T> warn(Integer code, String msg){
        return new CommonResponse<>(code, msg);
    }
}
