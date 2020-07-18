package com.boss.xtrain.exam.pojo.vo.test;

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
    private Long id;

    /**
     * 试卷名
     */
    private String name;

    /**
     * 试卷总分
     */
    private BigDecimal score;

    /**
     * 试卷类型
     */
    private String paperType;

    /**
     * 试卷难度
     */
    private String difficulty;

    /**
     * 试卷描述
     */
    private String description;

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
    private List<SubjectDetailsVO> subjectList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<SubjectDetailsVO> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectDetailsVO> subjectList) {
        this.subjectList = subjectList;
    }
}
