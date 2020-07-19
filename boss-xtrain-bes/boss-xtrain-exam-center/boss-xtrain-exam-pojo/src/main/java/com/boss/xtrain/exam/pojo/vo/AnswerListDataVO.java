package com.boss.xtrain.exam.pojo.vo;

import java.math.BigDecimal;

/**
 * @author ChenTong
 * @date 2020/7/19 15:49
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class AnswerListDataVO {
    /**
     * 答案记录id
     */
    private Long answerRecordId;

    /**
     * 考试记录id
     */
    private Long examRecordId;

    /**
     * 试题id
     */
    private Long paperSubjectId;

    /**
     * 我的答案
     */
    private String myAnswer;

    /**
     * 标准答案
     */
    private String standardAnswer;

    /**
     * 题目分值
     */
    private BigDecimal standardScore;

    /**
     * 该题得分
     */
    private BigDecimal score;

    /**
     * 阅卷官评价
     */
    private String evaluate;

    public Long getAnswerRecordId() {
        return answerRecordId;
    }

    public void setAnswerRecordId(Long answerRecordId) {
        this.answerRecordId = answerRecordId;
    }

    public Long getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }

    public Long getPaperSubjectId() {
        return paperSubjectId;
    }

    public void setPaperSubjectId(Long paperSubjectId) {
        this.paperSubjectId = paperSubjectId;
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

    public BigDecimal getStandardScore() {
        return standardScore;
    }

    public void setStandardScore(BigDecimal standardScore) {
        this.standardScore = standardScore;
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
