package com.boss.xtrain.paper.dto.examservice;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.util.List;

/**题目对象
 * @author lenovo
 */
public class ExamSubjectDTO {
    /**
     * 试卷ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;

    /**
     * 题目ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectId;

    /**
     * 题目类别
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 题目类型
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectTypeId;

    /**
     * 分数
     */
    private BigDecimal score;

    /**
     * 具体题目描述
     */
    private String subject;

    /**
     * 答案集合
     */
    private List<ExamAnswerDTO> answers;

    /**
     * 题目难度
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long difficult;

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getPaperSubjectId() {
        return paperSubjectId;
    }

    public void setPaperSubjectId(Long paperSubjectId) {
        this.paperSubjectId = paperSubjectId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<ExamAnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<ExamAnswerDTO> answers) {
        this.answers = answers;
    }

    public Long getDifficult() {
        return difficult;
    }

    public void setDifficult(Long difficult) {
        this.difficult = difficult;
    }

}

