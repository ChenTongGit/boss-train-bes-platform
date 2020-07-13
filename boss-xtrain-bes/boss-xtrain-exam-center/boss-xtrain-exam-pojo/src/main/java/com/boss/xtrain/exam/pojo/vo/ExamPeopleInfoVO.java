package com.boss.xtrain.exam.pojo.vo;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 考试人员VO
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 22:27
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPeopleInfoVO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 人员id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 验证码
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
