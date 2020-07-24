package com.boss.xtrain.exam.pojo.dto.query;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;

/**
 * @author ChenTong
 * @date 2020/7/13 23:02
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamReportQuery {

    /**
     * 考试标题
     */
    private String title;

    /**
     * 考试开始时间
     */
    private Date actualStartTime;

    /**
     * 考试结束时间
     */
    private Date actualEndTime;

    /**
     * 试卷发布人id
     */
    private Long publisher;

    private Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }
}
