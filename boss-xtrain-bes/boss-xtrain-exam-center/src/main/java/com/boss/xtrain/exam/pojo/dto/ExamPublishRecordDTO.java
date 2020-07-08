package com.boss.xtrain.exam.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;

import java.util.Arrays;
import java.util.Date;

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
     * 发布用户id
     */
    private Long publisher;

    /**
     * 考试开始时间
     */
    private Date startTime;

    /**
     * 考试结束时间
     */
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
     * 阅卷方式
     */
    private Integer markStopTime;

    /**
     * 所分配阅卷人id
     */
    private Long[] markPeople;

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

    public Integer getMarkStopTime() {
        return markStopTime;
    }

    public void setMarkStopTime(Integer markStopTime) {
        this.markStopTime = markStopTime;
    }

    public Long[] getMarkPeople() {
        return markPeople;
    }

    public void setMarkPeople(Long[] markPeople) {
        this.markPeople = markPeople;
    }

    public ExamPublishRecordDTO() {
    }

    @Override
    public String toString() {
        return "ExamPublishRecordDTO{" +
                "title='" + title + '\'' +
                ", publisher=" + publisher +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", planPeopleNum=" + planPeopleNum +
                ", description='" + description + '\'' +
                ", markStopTime=" + markStopTime +
                ", markPeople=" + Arrays.toString(markPeople) +
                '}';
    }
}
