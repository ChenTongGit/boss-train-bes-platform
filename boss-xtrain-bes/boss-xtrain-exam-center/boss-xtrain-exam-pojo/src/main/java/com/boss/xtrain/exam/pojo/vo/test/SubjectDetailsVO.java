package com.boss.xtrain.exam.pojo.vo.test;

import com.boss.xtrain.exam.pojo.vo.AnswerDetailsVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.util.List;

/**
 * 作答题目详情
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/13 21:14
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class SubjectDetailsVO {
    /**
     * 试题id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectId;

    /**
     * 试题内容
     */
    private String subject;

    /**
     * 试题类型
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 题目类别
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectTypeId;

    /**
     * 试题难度
     */
    private String difficult;

    /**
     * 试题分数
     */
    private BigDecimal score;

    /**
     * 试题对应的答案
     */
    private List<AnswerDetailsVO> answers;

    /**
     * 答案记录id，用于批卷
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long answerRecordId;

    /**
     * 我的答案
     */
    private String myAnswer;

    /**
     * 标准答案
     */
    private String standardAnswer;

    /**
     * 考生得分
     */
    private BigDecimal myScore;

    /**
     * 评价
     */
    private String evaluate="";

    public Long getPaperSubjectId() {
        return paperSubjectId;
    }

    public void setPaperSubjectId(Long paperSubjectId) {
        this.paperSubjectId = paperSubjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }


    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public List<AnswerDetailsVO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDetailsVO> answers) {
        this.answers = answers;
    }

    public Long getAnswerRecordId() {
        return answerRecordId;
    }

    public void setAnswerRecordId(Long answerRecordId) {
        this.answerRecordId = answerRecordId;
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

    public BigDecimal getMyScore() {
        return myScore;
    }

    public void setMyScore(BigDecimal myScore) {
        this.myScore = myScore;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
