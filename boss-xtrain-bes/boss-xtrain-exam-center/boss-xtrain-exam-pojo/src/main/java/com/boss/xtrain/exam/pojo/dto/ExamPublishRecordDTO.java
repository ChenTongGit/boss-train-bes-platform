package com.boss.xtrain.exam.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 考试发布记录添加dto
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 18:46
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPublishRecordDTO extends BaseDTO {

    /**
     * 发布考试标题
     */
    private String title;

    /**
     * qrcodeUrl
     */
    private String qrcodeUrl;

    /**
     * 试卷Id
     */
    private Long paperId;

    /**
     * 发布用户id
     */
    private Long publisher;
    /**
     * 发布人员名称
     */
    private String publisherName;


    /**
     * 考试开始时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 考试结束时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 计划参与考试人员
     */
    private Integer planPeopleNum;

    /**
     * 考试说明
     */
    private String description;

    /**
     * 阅卷结束时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date markStopTime;

    /**
     * 阅卷方式
     */
    private Integer markingMode;

    /**
     * 限制时间
     */
    private Long limitTime;

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Long limitTime) {
        this.limitTime = limitTime;
    }


    private List<ExamPublishToUserDTO>  markPeople;

    public List<ExamPublishToUserDTO> getMarkPeople() {
        return markPeople;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }


    public void setMarkPeople(List<ExamPublishToUserDTO> markPeople) {
        this.markPeople = markPeople;
    }


    public Integer getMarkingMode() {
        return markingMode;
    }

    public void setMarkingMode(Integer markingMode) {
        this.markingMode = markingMode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getPlanPeopleNum() {
        return planPeopleNum;
    }

    public void setPlanPeopleNum(Integer planPeopleNum) {
        this.planPeopleNum = planPeopleNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getMarkStopTime() {
        return markStopTime;
    }

    public void setMarkStopTime(Date markStopTime) {
        this.markStopTime = markStopTime;
    }



    public ExamPublishRecordDTO() {
    }

    @Override
    public String toString() {
        return "ExamPublishRecordDTO{" +
                "title='" + title + '\'' +
                ", publisher=" + publisher +
                ", publisherName='" + publisherName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", planPeopleNum=" + planPeopleNum +
                ", description='" + description + '\'' +
                ", markStopTime=" + markStopTime +
                ", markingMode=" + markingMode +
                ", markPeople=" + markPeople +
                "} ";
    }
}
