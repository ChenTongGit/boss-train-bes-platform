package com.boss.xtrain.exam.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 考试记录vo
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/11 9:21
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamRecordVO extends BaseVO {

    /**
     * 考试记录id
     */
    private Long id;

    /**
     * 考试名
     */
    private String title;

    /**
     * 场次编号
     */
    private String examSession;

    /**
     * 考生姓名
     */
    private String name;

    /**
     * 考生手机号
     */
    private String mobile;

    /**
     * 客观题得分
     */
    private BigDecimal objectiveSubjectScore;

    /**
     * 计划结束时间
     */
    private Date planEndTime;

    /**
     * 考试开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date actualStartTime;

    /**
     * 考试结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date actualEndTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getObjectiveSubjectScore() {
        return objectiveSubjectScore;
    }

    public void setObjectiveSubjectScore(BigDecimal objectiveSubjectScore) {
        this.objectiveSubjectScore = objectiveSubjectScore;
    }

    public String getTitle() {
        return title;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExamSession() {
        return examSession;
    }

    public void setExamSession(String examSession) {
        this.examSession = examSession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
}
