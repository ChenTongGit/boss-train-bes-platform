package com.boss.xtrain.exam.pojo.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 阅卷列表dto 查询出需要的阅卷
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/14 6:47
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class MarkingDataListDto {

    /**
     * 考试记录Id，用于操作
     */
    private Long examRecordId;

    /**
     * 试卷id，用于批卷界面查询试卷
     */
    private Long paperId;

    /**
     * 试卷标题
     */
    private String title;

    /**
     * 答卷人
     */
    private String name;

    /**
     * 考试场次
     */
    private String examSession;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 答卷人手机号
     */
    private String mobile;

    /**
     * 发布时间，created_time
     */
    private Date publishTime;

    /**
     * 交卷时间
     */
    private Date actualEndTime;

    /**
     * 阅卷终止时间
     */
    private Date markingStopTime;

    /**
     * 客观题得分
     */
    private BigDecimal objectiveSubjectScore;

    /**
     * 主观题得分
     */
    private BigDecimal subjectiveSubjectScore;

    /**
     * 系统评价
     */
    private String systemEvaluate;

    /**
     * 版本号
     */
    private Long version;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getObjectiveSubjectScore() {
        return objectiveSubjectScore;
    }

    public void setObjectiveSubjectScore(BigDecimal objectiveSubjectScore) {
        this.objectiveSubjectScore = objectiveSubjectScore;
    }

    public BigDecimal getSubjectiveSubjectScore() {
        return subjectiveSubjectScore;
    }

    public void setSubjectiveSubjectScore(BigDecimal subjectiveSubjectScore) {
        this.subjectiveSubjectScore = subjectiveSubjectScore;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExamSession() {
        return examSession;
    }

    public void setExamSession(String examSession) {
        this.examSession = examSession;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public Date getMarkingStopTime() {
        return markingStopTime;
    }

    public void setMarkingStopTime(Date markingStopTime) {
        this.markingStopTime = markingStopTime;
    }

    public String getSystemEvaluate() {
        return systemEvaluate;
    }

    public void setSystemEvaluate(String systemEvaluate) {
        this.systemEvaluate = systemEvaluate;
    }
}
