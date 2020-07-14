package com.boss.xtrain.exam.pojo.dto.query;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;

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
    private Long id;

    /**
     * 考试名
     */
    private String title;

    /**
     * 考试开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planStartTime;

    /**
     * 考试结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planEndTime;

    /**
     * 试卷发布人
     */
    private Long publisher;

    public Long getId() {
        return id;
    }

    /**
     * 公司id
     */
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
