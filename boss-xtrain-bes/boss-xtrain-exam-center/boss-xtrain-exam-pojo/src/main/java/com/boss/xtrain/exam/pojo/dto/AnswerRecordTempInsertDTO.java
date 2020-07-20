package com.boss.xtrain.exam.pojo.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;

/**
 * 作答记录添加dto
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 18:07
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class AnswerRecordTempInsertDTO {


    /**
     * 考试记录id
     */
    private Long examRecordId;

    /**
     * 考生回答内容
     */
    private String myAnswer;

    /**
     * 考试试题id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectId;

    /**
     * 题目类型id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectTypeId;

    /**
     * 该题目分值
     */
    private BigDecimal standardScore;

    public BigDecimal getStandardScore() {
        return standardScore;
    }

    public void setStandardScore(BigDecimal standardScore) {
        this.standardScore = standardScore;
    }

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
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


}
