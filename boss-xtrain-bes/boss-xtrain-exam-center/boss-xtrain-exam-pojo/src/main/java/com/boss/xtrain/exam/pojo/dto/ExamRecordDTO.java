package com.boss.xtrain.exam.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 考试记录dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 14:47
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamRecordDTO extends BaseDTO {
    /**
     * 考试发布记录id
     */
    private Long publishId;

    /**
     * 考生id
     */
    private Long examPeople;

    /**
     * 计划开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date planStartTime;

    /**
     * 计划结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date planEndTime;

    /**
     * 实际开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date actualStartTime;

    /**
     * 实际结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date actualEndTime;

    /**
     * 客观题得分
     */
    private BigDecimal objectiveSubjectScore;

    /**
     * 阅卷官id
     */
    private Long markUserId;

    /**
     * 阅卷官姓名
     */
    private String name;

    /**
     * 客观题得分
     */
    private BigDecimal subjectiveSubjectScore;

    /**
     * 阅卷分配时间
     */
    private Date markingAssignTime;

    /**
     * 总分
     */
    private BigDecimal score;

    /**
     * 能力标签
     */
    private String systemEvaluate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getExamPeople() {
        return examPeople;
    }

    public void setExamPeople(Long examPeople) {
        this.examPeople = examPeople;
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

    public BigDecimal getObjectiveSubjectScore() {
        return objectiveSubjectScore;
    }

    public void setObjectiveSubjectScore(BigDecimal objectiveSubjectScore) {
        this.objectiveSubjectScore = objectiveSubjectScore;
    }

    public Long getMarkUserId() {
        return markUserId;
    }

    public void setMarkUserId(Long markUserId) {
        this.markUserId = markUserId;
    }

    public BigDecimal getSubjectiveSubjectScore() {
        return subjectiveSubjectScore;
    }

    public void setSubjectiveSubjectScore(BigDecimal subjectiveSubjectScore) {
        this.subjectiveSubjectScore = subjectiveSubjectScore;
    }

    public Date getMarkingAssignTime() {
        return markingAssignTime;
    }

    public void setMarkingAssignTime(Date markingAssignTime) {
        this.markingAssignTime = markingAssignTime;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getSystemEvaluate() {
        return systemEvaluate;
    }

    public void setSystemEvaluate(String systemEvaluate) {
        this.systemEvaluate = systemEvaluate;
    }
}
