package com.boss.xtrain.exam.pojo.vo;

import com.boss.xtrain.paper.dto.examservice.ExamSubjectDTO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.util.List;

/**
 * 考试试卷预览vo
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/18 19:30
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPaperPreviewVO {

    /**
     * 试卷id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;

    /**
     * 试卷名称
     */
    private String paperName;

    /**
     * 试卷类型
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 试卷难度
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long difficuty;

    /**
     * 试卷分数
     */
    private BigDecimal score;

    /**
     * 试卷描述
     */
    private String discript;

    /**
     * 试卷试题列表
     */
    private List<ExamSubjectDTO> subjects;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getDifficuty() {
        return difficuty;
    }

    public void setDifficuty(Long difficuty) {
        this.difficuty = difficuty;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getDiscript() {
        return discript;
    }

    public void setDiscript(String discript) {
        this.discript = discript;
    }

    public List<ExamSubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<ExamSubjectDTO> subjects) {
        this.subjects = subjects;
    }
}
