package com.boss.xtrain.exam.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * 考试人员注册所需数据
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 23:22
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPeopleRegisterDTO {
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String name;

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

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    private Boolean sex;

    /**
     * 大学
     */
    @NotBlank(message = "毕业院校不能为空")
    private String university;

    /**
     * 专业
     */
    @NotBlank(message = "专业不能为空")
    private String major;

    /**
     * 照片url
     */
    @NotBlank(message = "照片不能为空")
    private String photoUrl;

    /**
     * 毕业时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date graduateTime;

    /**
     * 荣誉
     */
    private String awardInfo;

    /**
     * 备注
     */
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Date getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(Date graduateTime) {
        this.graduateTime = graduateTime;
    }

    public String getAwardInfo() {
        return awardInfo;
    }

    public void setAwardInfo(String awardInfo) {
        this.awardInfo = awardInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ExamPeopleRegisterDTO() {
        // 构造函数
    }



    @Override
    public String toString() {
        return "ExamPeopleRegisterDTO{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", graduateTime=" + graduateTime +
                ", awardInfo='" + awardInfo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
