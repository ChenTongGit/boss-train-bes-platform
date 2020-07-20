package com.boss.xtrain.exam.pojo.vo;

import com.boss.xtrain.exam.pojo.vo.test.SubjectDetailsVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.util.List;

/**
 * 考试作答详情
 *
 * @author ChenTong
 * @date 2020/7/13 21:13
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class PaperSubjectAnswerVO {
    /**
     * 试卷id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;

    /**
     * 试卷名
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private String paperName;

    /**
     * 试卷总分
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal score;

    /**
     * 试卷类型
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private String paperType;

    /**
     * 试卷难度
     */
    private String difficulty;

    /**
     * 试卷描述
     */
    private String discript;

    /**
     * 下载次数
     */
    private Integer downloadTimes;

    /**
     * 发布次数
     */
    private Integer publishTimes;

    /**
     * 试卷版本
     */
    private String version;


    /**
     * 题目列表
     */
    private List<SubjectDetailsVO> subjects;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDiscript() {
        return discript;
    }

    public void setDiscript(String discript) {
        this.discript = discript;
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public Integer getPublishTimes() {
        return publishTimes;
    }

    public void setPublishTimes(Integer publishTimes) {
        this.publishTimes = publishTimes;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<SubjectDetailsVO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDetailsVO> subjects) {
        this.subjects = subjects;
    }
}
