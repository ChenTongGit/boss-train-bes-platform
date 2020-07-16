package com.boss.xtrain.exam.pojo.dto.query;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 考试发布记录查询封装
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 21:05
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPublishRecordQuery extends BaseQuery {
    /**
     * 发布人员姓名
     */
    private String publisherName;

    /**
     * title
     */
    private String title;

    /**
     * 发布人员ID
     */
    private Long publisher;

    /**
     * 考试开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 考试结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 发布时间段-左
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date leftPublishTime;

    /**
     * 发布时间段-右
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rightPublishTime;

    /**
     * 批量删除时使用的ids
     */
    private String ids;

    /**
     * 公司id
     */
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

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getLeftPublishTime() {
        return leftPublishTime;
    }

    public void setLeftPublishTime(Date leftPublishTime) {
        this.leftPublishTime = leftPublishTime;
    }

    public Date getRightPublishTime() {
        return rightPublishTime;
    }

    public void setRightPublishTime(Date rightPublishTime) {
        this.rightPublishTime = rightPublishTime;
    }


    public ExamPublishRecordQuery() {
    }
}
