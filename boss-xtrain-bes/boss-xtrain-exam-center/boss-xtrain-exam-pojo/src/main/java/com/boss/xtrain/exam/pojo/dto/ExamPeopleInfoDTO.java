package com.boss.xtrain.exam.pojo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 考生基础信息dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 10:00
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPeopleInfoDTO{
    /**
     * 姓名
     */
    private String name;

    /**
     * 考生id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 手机验证码
     */
    private String verificationCode;

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
