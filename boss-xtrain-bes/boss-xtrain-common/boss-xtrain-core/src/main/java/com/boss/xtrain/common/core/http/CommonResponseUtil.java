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
     * @return com.boss.xtrain.common.core.http.CommonResponse<T>
     * @date 2020/7/4 13:26
     */
    public static <T> CommonResponse<T> ok(String code, String msg, T data){

        CommonResponse<T> commonResponse = new CommonResponse<>();
        AppUtils.setResponseExtendInfo(commonResponse, msg, code);
        commonResponse.setData(data);
        return commonResponse;
    }


    public static <T> CommonResponse<T> ok(T data){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        AppUtils.setResponseExtendInfo(commonResponse);
        commonResponse.setData(data);
        return commonResponse;
    }

    public static <T> CommonResponse<T> ok(String code, String msg){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        AppUtils.setResponseExtendInfo(commonResponse, msg, code);
        return commonResponse;
    }

    public static <T> CommonResponse<T> error(String code, String msg){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        AppUtils.setResponseExtendInfo(commonResponse, msg, code);
        return commonResponse;
    }

    public static <T> CommonResponse<T> error(SystemError error){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        AppUtils.setResponseExtendInfo(commonResponse, error.getMessage(), error.getCode());
        return commonResponse;
    }
    public static <T> CommonResponse<T> error(BusinessError error){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        AppUtils.setResponseExtendInfo(commonResponse, error.getMessage(), error.getCode());
        return commonResponse;
    }


    public static <T> CommonResponse<T> warn(String code, String msg){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        AppUtils.setResponseExtendInfo(commonResponse, code, msg);
        return commonResponse;
    }
}
