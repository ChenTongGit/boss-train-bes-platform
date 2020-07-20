package com.boss.xtrain.exam.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;

import java.math.BigDecimal;

/**
 * 作答记录dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 18:07
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class AnswerRecordDTO extends BaseDTO {


    /**
     * 考试记录id
     */
    private Long examRecordId;

    /**
     * 考生回答内容
     */
    private String myAnswer;

    /**
     * 标准答案
     */
    private String standardAnswer;

    /**
     * 本题的分数
     */
    private BigDecimal score;

    /**
     * 评价
     */
    private String evaluate;

    /**
     * 试卷试题id
     */
    private Long paperSubjectId;

    /**
     * 题目类型id
     */
    private Long subjectTypeId;

    /**
     * 该题目分值
     */
    private BigDecimal standardScore;

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public BigDecimal getStandardScore() {
        return standardScore;
    }

    public void setStandardScore(BigDecimal standardScore) {
        this.standardScore = standardScore;
    }

    public Long getPaperSubjectId() {
        return paperSubjectId;
    }

    public void setPaperSubjectId(Long paperSubjectId) {
        this.paperSubjectId = paperSubjectId;
    }

    public Long getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }

    public String getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    public String getStandardAnswer() {
        return standardAnswer;
    }

    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
