package com.boss.xtrain.exam.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;

import java.util.Date;
import java.util.Map;

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
     * 考试发布记录id
     */
    private Long id;

    /**
     * 考试标题
     */
    private String title;

    /**
     * 发布人ID
     */
    private Long publisherID;

    /**
     * 考试开始时间
     */
    private Date startTime;

    /**
     * 考试结束时间
     */
    private Date endTime;

    /**
     * 计划参与人数
     */
    private Integer planPeopleNum;

    /**
     * 阅卷结束时间
     */
    private Date markStopTime;

    /**
     * 分配的阅卷官列表 name,id
     */
    private Map<String, Long> markPeople;

    /**
     * 考试说明
     */
    private String description;

    /**
     * 二维码链接
     */
    private String qrCodeUrl;

    /**
     * 是否发布
     */
    private Integer status;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public Map<String, Long> getMarkPeople() {
        return markPeople;
    }

    public void setMarkPeople(Map<String, Long> markPeople) {
        this.markPeople = markPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }


}
