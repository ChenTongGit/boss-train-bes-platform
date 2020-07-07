package com.boss.xtrain.exam.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_exam_publish_record")
public class ExamPublishRecord extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.t_p_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long tPId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.title
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.publisher
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long publisher;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.plan_pepole_num
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Integer planPepoleNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.limit_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Integer limitTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.descript
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String descript;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.marking_mode
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Integer markingMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.marking_stop_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date markingStopTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.qrcode_url
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String qrcodeUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long orgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long updatedBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date updatedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.field1
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String field1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_publish_record.field2
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String field2;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.id
     *
     * @return the value of t_exam_publish_record.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.id
     *
     * @param id the value for t_exam_publish_record.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.t_p_id
     *
     * @return the value of t_exam_publish_record.t_p_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long gettPId() {
        return tPId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.t_p_id
     *
     * @param tPId the value for t_exam_publish_record.t_p_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void settPId(Long tPId) {
        this.tPId = tPId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.title
     *
     * @return the value of t_exam_publish_record.title
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.title
     *
     * @param title the value for t_exam_publish_record.title
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.publisher
     *
     * @return the value of t_exam_publish_record.publisher
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getPublisher() {
        return publisher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.publisher
     *
     * @param publisher the value for t_exam_publish_record.publisher
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.start_time
     *
     * @return the value of t_exam_publish_record.start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.start_time
     *
     * @param startTime the value for t_exam_publish_record.start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.end_time
     *
     * @return the value of t_exam_publish_record.end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.end_time
     *
     * @param endTime the value for t_exam_publish_record.end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.plan_pepole_num
     *
     * @return the value of t_exam_publish_record.plan_pepole_num
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Integer getPlanPepoleNum() {
        return planPepoleNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.plan_pepole_num
     *
     * @param planPepoleNum the value for t_exam_publish_record.plan_pepole_num
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setPlanPepoleNum(Integer planPepoleNum) {
        this.planPepoleNum = planPepoleNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.limit_time
     *
     * @return the value of t_exam_publish_record.limit_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Integer getLimitTime() {
        return limitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.limit_time
     *
     * @param limitTime the value for t_exam_publish_record.limit_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.descript
     *
     * @return the value of t_exam_publish_record.descript
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getDescript() {
        return descript;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.descript
     *
     * @param descript the value for t_exam_publish_record.descript
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setDescript(String descript) {
        this.descript = descript;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.marking_mode
     *
     * @return the value of t_exam_publish_record.marking_mode
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Integer getMarkingMode() {
        return markingMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.marking_mode
     *
     * @param markingMode the value for t_exam_publish_record.marking_mode
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setMarkingMode(Integer markingMode) {
        this.markingMode = markingMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.marking_stop_time
     *
     * @return the value of t_exam_publish_record.marking_stop_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getMarkingStopTime() {
        return markingStopTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.marking_stop_time
     *
     * @param markingStopTime the value for t_exam_publish_record.marking_stop_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setMarkingStopTime(Date markingStopTime) {
        this.markingStopTime = markingStopTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.qrcode_url
     *
     * @return the value of t_exam_publish_record.qrcode_url
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.qrcode_url
     *
     * @param qrcodeUrl the value for t_exam_publish_record.qrcode_url
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.status
     *
     * @return the value of t_exam_publish_record.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.status
     *
     * @param status the value for t_exam_publish_record.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.company_id
     *
     * @return the value of t_exam_publish_record.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.company_id
     *
     * @param companyId the value for t_exam_publish_record.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.org_id
     *
     * @return the value of t_exam_publish_record.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.org_id
     *
     * @param orgId the value for t_exam_publish_record.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.created_by
     *
     * @return the value of t_exam_publish_record.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.created_by
     *
     * @param createdBy the value for t_exam_publish_record.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.created_time
     *
     * @return the value of t_exam_publish_record.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.created_time
     *
     * @param createdTime the value for t_exam_publish_record.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.updated_by
     *
     * @return the value of t_exam_publish_record.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.updated_by
     *
     * @param updatedBy the value for t_exam_publish_record.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.updated_time
     *
     * @return the value of t_exam_publish_record.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.updated_time
     *
     * @param updatedTime the value for t_exam_publish_record.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.version
     *
     * @return the value of t_exam_publish_record.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.version
     *
     * @param version the value for t_exam_publish_record.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.field1
     *
     * @return the value of t_exam_publish_record.field1
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getField1() {
        return field1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.field1
     *
     * @param field1 the value for t_exam_publish_record.field1
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setField1(String field1) {
        this.field1 = field1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_publish_record.field2
     *
     * @return the value of t_exam_publish_record.field2
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getField2() {
        return field2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_publish_record.field2
     *
     * @param field2 the value for t_exam_publish_record.field2
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setField2(String field2) {
        this.field2 = field2;
    }
}