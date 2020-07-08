package com.boss.xtrain.common.core.http;

/**
 * 封装响应数据
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 16:31
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class CommonResponse<T> {
    ResponseHeader header;
    T data;

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
