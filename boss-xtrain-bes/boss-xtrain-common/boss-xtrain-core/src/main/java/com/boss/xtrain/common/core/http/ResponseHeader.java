package com.boss.xtrain.common.core.http;

/**
 * 响应头信息
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 16:34
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ResponseHeader {
    /**
     * 版本
     */
    private String version;
    /**
     * 应答码
     */
    private String code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 加密标志
     */
    private Integer encryptFlag;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getEncryptFlag() {
        return encryptFlag;
    }

    public void setEncryptFlag(Integer encryptFlag) {
        this.encryptFlag = encryptFlag;
    }
}
