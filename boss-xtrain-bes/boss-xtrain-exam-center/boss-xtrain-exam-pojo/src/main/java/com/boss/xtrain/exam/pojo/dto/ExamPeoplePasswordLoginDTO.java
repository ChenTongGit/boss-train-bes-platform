package com.boss.xtrain.exam.pojo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 考生密码登录dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 9:35
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPeoplePasswordLoginDTO {
    /**
     * 手机号码
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式错误")
    private String mobile;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 12, message = "密码长度不能小于6大于12位")
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
