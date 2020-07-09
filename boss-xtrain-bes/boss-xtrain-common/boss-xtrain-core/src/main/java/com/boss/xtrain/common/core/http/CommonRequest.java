package com.boss.xtrain.common.core.http;

import java.io.Serializable;
import java.util.Map;

/**
 * @description: 请求封装
 * @author: WenZhi Luo
 * @create: 2020-07-01
 * @since
 */
public class CommonRequest<T> implements Serializable {
    private static final long serialVersionUID = -3704768961834196684L;
    /**
     * 请求头信息
     * */
    private RequestHeader header;
    /**
     * 请求题内容，用来放置DTO
     * */
    private T body;

    /**
     * getter setter方法
     * */
    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    /**
     * 全参和无参构造方法
     * */
    public CommonRequest(RequestHeader header, T body) {
        this.header = header;
        this.body = body;
    }

    public CommonRequest() {
    }
}
