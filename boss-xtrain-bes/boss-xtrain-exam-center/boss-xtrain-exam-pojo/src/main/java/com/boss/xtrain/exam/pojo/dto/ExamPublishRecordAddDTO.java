package com.boss.xtrain.exam.pojo.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author TLX
 * @date 2019.12.12
 * @time 15:04
 */
public class ExamPublishRecordAddDTO {

    /**
     * 试卷id
     */
    @NotNull(message = "试卷不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;

    /**
     * 考试标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;

    /**
     * 考试开始时间
     */
    private Date startTime;

    /**
     * 考试结束时间
     */
    @Future(message = "必须是未来的时间")
    private Date endTime;

    /**
     * 计划参加人数
     */
    @Min(value = 0, message = "考试人数必须大于0")
    private Integer planPeopleNum;

    /**
     * 考试时长
     */
    @Min(value = 0, message = "考试时长必须大于0")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long limitTime;

    /**
     * 阅卷官
     */
    // @NotNull(message = "阅卷官不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> markPeople;

    /**
     * 评卷方式
     */
    private Integer markingMode;

    /**
     * 阅卷截止时间
     */
    private Date markingStopTime;

    /**
     * 考试说明
     */
    private String description;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Long limitTime) {
        this.limitTime = limitTime;
    }

    public List<Long> getMarkPeople() {
        return markPeople;
    }

    public void setMarkPeople(List<Long> markPeople) {
        this.markPeople = markPeople;
    }

    public Integer getMarkingMode() {
        return markingMode;
    }

    public void setMarkingMode(Integer markingMode) {
        this.markingMode = markingMode;
    }

    public Date getMarkingStopTime() {
        return markingStopTime;
    }

    public void setMarkingStopTime(Date markingStopTime) {
        this.markingStopTime = markingStopTime;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
