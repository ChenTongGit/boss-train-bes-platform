package com.boss.xtrain.exam.pojo.dto.query;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;

/**
 * 考试记录查询封装
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 15:46
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamRecordQuery extends BaseQuery {
    /**
     * 考试记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 考试名
     */
    private String title;

    /**
     * 考试开始时间
     */
    private Date planStartTime;

    /**
     * 考试结束时间
     */
    private Date planEndTime;

    /**
     * 试卷发布人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long publisher;

    /**
     * 考试场次编号
     */
    private String examSession;

    public Long getId() {
        return id;
    }

    public String getExamSession() {
        return examSession;
    }

    public void setExamSession(String examSession) {
        this.examSession = examSession;
    }

    /**
     * 公司id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    public Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }
}
