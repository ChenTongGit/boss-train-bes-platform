package com.boss.xtrain.exam.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 考试发布记录vo
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 21:12
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPublishRecordVO extends BaseVO {

    /**
     * 考试标题
     */
    private String title;

    /**
     * 发布人ID
     */
    private Long publisherID;

    /**
     * 发布人姓名
     */
    private String publisherName;

    /**
     * 考试开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    private Date startTime;

    /**
     * 考试结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 计划参与人数
     */
    private Integer planPeopleNum;

    /**
     * 阅卷结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date markStopTime;

    /**
     * 分配的阅卷官列表 name,id
     */
    private List<ExamPublishToUserVO> markPeople;

    /**
     * 考试说明
     */
    private String description;

    /**
     * 二维码链接
     */
    private String qrcodeUrl;

    /**
     * 考试时间限制
     */
    private Long limitTime;

    public Long getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Long limitTime) {
        this.limitTime = limitTime;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public ExamPublishRecordVO() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Long publisherID) {
        this.publisherID = publisherID;
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

    public Integer getPlanPeopleNum() {
        return planPeopleNum;
    }

    public void setPlanPeopleNum(Integer planPeopleNum) {
        this.planPeopleNum = planPeopleNum;
    }

    public Date getMarkStopTime() {
        return markStopTime;
    }

    public void setMarkStopTime(Date markStopTime) {
        this.markStopTime = markStopTime;
    }

    public List<ExamPublishToUserVO> getMarkPeople() {
        return markPeople;
    }

    public void setMarkPeople(List<ExamPublishToUserVO> markPeople) {
        this.markPeople = markPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }


    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

}