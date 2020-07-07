package com.boss.xtrain.exam.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_exam_people")
public class ExamPeople extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.mobile
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.email
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.password
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.name
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.sex
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Boolean sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.university
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String university;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.major
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String major;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.photo_url
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String photoUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.graduate_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date graduateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.prizie_info
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String prizieInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.remark
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long orgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long updatedBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date updatedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_people.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.id
     *
     * @return the value of t_exam_people.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.id
     *
     * @param id the value for t_exam_people.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.mobile
     *
     * @return the value of t_exam_people.mobile
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.mobile
     *
     * @param mobile the value for t_exam_people.mobile
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.email
     *
     * @return the value of t_exam_people.email
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.email
     *
     * @param email the value for t_exam_people.email
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.password
     *
     * @return the value of t_exam_people.password
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.password
     *
     * @param password the value for t_exam_people.password
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.name
     *
     * @return the value of t_exam_people.name
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.name
     *
     * @param name the value for t_exam_people.name
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.sex
     *
     * @return the value of t_exam_people.sex
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.sex
     *
     * @param sex the value for t_exam_people.sex
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.university
     *
     * @return the value of t_exam_people.university
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getUniversity() {
        return university;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.university
     *
     * @param university the value for t_exam_people.university
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.major
     *
     * @return the value of t_exam_people.major
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.major
     *
     * @param major the value for t_exam_people.major
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.photo_url
     *
     * @return the value of t_exam_people.photo_url
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.photo_url
     *
     * @param photoUrl the value for t_exam_people.photo_url
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.graduate_time
     *
     * @return the value of t_exam_people.graduate_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getGraduateTime() {
        return graduateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.graduate_time
     *
     * @param graduateTime the value for t_exam_people.graduate_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setGraduateTime(Date graduateTime) {
        this.graduateTime = graduateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.prizie_info
     *
     * @return the value of t_exam_people.prizie_info
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getPrizieInfo() {
        return prizieInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.prizie_info
     *
     * @param prizieInfo the value for t_exam_people.prizie_info
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setPrizieInfo(String prizieInfo) {
        this.prizieInfo = prizieInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.remark
     *
     * @return the value of t_exam_people.remark
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.remark
     *
     * @param remark the value for t_exam_people.remark
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.status
     *
     * @return the value of t_exam_people.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.status
     *
     * @param status the value for t_exam_people.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.company_id
     *
     * @return the value of t_exam_people.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.company_id
     *
     * @param companyId the value for t_exam_people.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.org_id
     *
     * @return the value of t_exam_people.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.org_id
     *
     * @param orgId the value for t_exam_people.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.created_by
     *
     * @return the value of t_exam_people.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.created_by
     *
     * @param createdBy the value for t_exam_people.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.created_time
     *
     * @return the value of t_exam_people.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.created_time
     *
     * @param createdTime the value for t_exam_people.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.updated_by
     *
     * @return the value of t_exam_people.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.updated_by
     *
     * @param updatedBy the value for t_exam_people.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.updated_time
     *
     * @return the value of t_exam_people.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.updated_time
     *
     * @param updatedTime the value for t_exam_people.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_people.version
     *
     * @return the value of t_exam_people.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_people.version
     *
     * @param version the value for t_exam_people.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}