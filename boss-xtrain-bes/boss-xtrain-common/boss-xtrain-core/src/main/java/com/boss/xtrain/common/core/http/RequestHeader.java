package com.boss.xtrain.common.core.http;

import java.io.Serializable;

/**
 * @author FHF
 * @description 通用请求中的请求头部信息
 * @create Created in 2020/7/2 10:56
 * @since 1.0
 */
public class RequestHeader implements Serializable {
    private static final long serialVersionUID = -3652660248558770842L;
    /**
     * 流水号
     * **/
    private String serialNumber;
    /**
     * 微服务调用流水号
     * 调用微服务是使用该属性存储流水号
     * **/
    private String serviceSerialNumber;
    /**
     * 系统版本
     */
    private String version;

    /**
     * 请求中的token信息
     */
    private String token;

    /**
     * 具体存放的DTO类型
     */
    private String bodyType;

    /**
     * 设备编号
     * 当前设计系统设计中暂时没有用
     */
    private String deviceId;

    /**
     * 设备类型
     */
    private Integer deviceType;

    /**
     * 系统类型或者浏览器型号
     */
    private String osOrBrowser;

    /**
     * 是否加密 1 加密 0 不加密 默认不加密
     */
    private Integer encryptFlag;

    /**
     * getter setter 方法
     * */

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getServiceSerialNumber() {
        return serviceSerialNumber;
    }

    public void setServiceSerialNumber(String serviceSerialNumber) {
        this.serviceSerialNumber = serviceSerialNumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getOsOrBrowser() {
        return osOrBrowser;
    }

    public void setOsOrBrowser(String osOrBrowser) {
        this.osOrBrowser = osOrBrowser;
    }

    public Integer getEncryptFlag() {
        return encryptFlag;
    }

    public void setEncryptFlag(Integer encryptFlag) {
        this.encryptFlag = encryptFlag;
    }
    /**
     * 无参构造方法
     * */
    public RequestHeader() {
        //无参构造方法
    }
}
