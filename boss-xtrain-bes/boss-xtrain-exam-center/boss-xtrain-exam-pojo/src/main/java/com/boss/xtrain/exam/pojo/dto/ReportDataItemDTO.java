package com.boss.xtrain.exam.pojo.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 报表项
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/13 23:12
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ReportDataItemDTO {

    /**
     * 考生姓名
     */
    private String peopleName;

    /**
     * 考生性别
     */
    private Integer sex;

    /**
     * 考试标题
     */
    private String title;

    /**
     * 客观题得分
     */
    private BigDecimal objectiveMark;

    /**
     * 主观题得分
     */
    private BigDecimal subjectiveMark;

    /**
     * 总分
     */
    private BigDecimal score;

    /**
     * 排名
     */
    private Integer rank;

    /**
     * 实际考试开始时间（用于计算考试消耗时间）
     */
    private Date actualStartTime;

    /**
     * 实际考试结束时间（用于计算考试消耗时间）
     */
    private Date actualEndTime;

    /**
     * 考试耗时
     */
    private String examTimeConsuming;

    /**
     * 能力标签
     */
    private String abilityTag;

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getObjectiveMark() {
        return objectiveMark;
    }

    public void setObjectiveMark(BigDecimal objectiveMark) {
        this.objectiveMark = objectiveMark;
    }

    public BigDecimal getSubjectiveMark() {
        return subjectiveMark;
    }

    public void setSubjectiveMark(BigDecimal subjectiveMark) {
        this.subjectiveMark = subjectiveMark;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public String getExamTimeConsuming() {
        return examTimeConsuming;
    }

    public void setExamTimeConsuming(String examTimeConsuming) {
        this.examTimeConsuming = examTimeConsuming;
    }

    public String getAbilityTag() {
        return abilityTag;
    }

    public void setAbilityTag(String abilityTag) {
        this.abilityTag = abilityTag;
    }
}
