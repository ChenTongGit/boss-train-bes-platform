package com.boss.xtrain.common.core.http;

import com.boss.xtrain.common.core.constant.ResponseConstant;
import lombok.Data;

/**
 * HTTP请求响应封装
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/4 6:57
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Data
public class CommonResponse<T>{

    // 应用程序版本号
    private String version = ResponseConstant.SYSTEM_VERSION;
    // 返回应答码:0表示成功
    private Integer code;
    // 返回信息
    private String msg;
    // 加密标志:1标记加密|0标记不加密
    private Integer flag = ResponseConstant.NOT_ENCRYPT_FLAG;
    // 泛型。存放VO对象
    private T data;

    public CommonResponse(Integer code, String msg, Integer flag, T data) {
        this.code = code;
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public CommonResponse(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public CommonResponse(Integer code, String msg, T data){
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

}
