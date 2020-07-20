package com.boss.xtrain.paper.dto.examservice;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @version: V1.0
 * @className: ExamAnswerDTO
 * @packageName: com.boss.bes.paper.pojo.dto.papermanage
 * @description: 答案对象
 * @data: 11:00 2020/1/6
 **/
public class ExamAnswerDTO {
    /**
     * 题目ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectId;
    /**
     * 答案ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectAnswerId;
    /**
     * 答案
     */
    private String answer;
    /**
     * 是否是正确答案
     */
    private Boolean rightAnswer;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getPaperSubjectAnswerId() {
        return paperSubjectAnswerId;
    }

    public void setPaperSubjectAnswerId(Long paperSubjectAnswerId) {
        this.paperSubjectAnswerId = paperSubjectAnswerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

}
