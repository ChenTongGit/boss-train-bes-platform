package com.boss.xtrain.common.core.http;

import com.boss.xtrain.common.core.constant.ResponseConstant;

/**
 * 系统工具类
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 16:41
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class AppUtils {
    private AppUtils(){
    }

    /**
     * 自动封装响应头
     * @param commonResponse 响应封装对象
     */
    public static <T> void setResponseExtendInfo(CommonResponse<T> commonResponse){
        ResponseHeader header = new ResponseHeader();
        header.setEncryptFlag(ResponseConstant.NOT_ENCRYPT_FLAG);
        header.setVersion(ResponseConstant.SYSTEM_VERSION);
        header.setCode(ResponseConstant.SUCCESS);
        header.setMsg(ResponseConstant.SUCCESS_MSG);
        commonResponse.setHeader(header);
    }

    /**
     * 封装响应头
     * @param commonResponse 响应封装对象
     * @param msg 响应信息
     * @param code 响应应答码
     */
    public static <T> void setResponseExtendInfo(CommonResponse<T> commonResponse, String msg, String code){
        ResponseHeader header = new ResponseHeader();
        header.setEncryptFlag(ResponseConstant.NOT_ENCRYPT_FLAG);
        header.setVersion(ResponseConstant.SYSTEM_VERSION);
        header.setCode(code);
        header.setMsg(msg);
        commonResponse.setHeader(header);
    }

}
