package com.boss.xtrain.exam.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 作答详情vo
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/13 21:15
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class AnswerDetailsVO {
    /**
     * 试卷试题答案id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectAnswerId;

    /**
     * 对应的试题id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectId;

    /**
     * 答案内容
     */
    private String answer;

    /**
     * 图片路径
     */
    private String imageUrl;

    /**
     * 是否为正确答案
     */
    private Boolean rightAnswer;


    public Boolean getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Long getPaperSubjectAnswerId() {
        return paperSubjectAnswerId;
    }

    public void setPaperSubjectAnswerId(Long paperSubjectAnswerId) {
        this.paperSubjectAnswerId = paperSubjectAnswerId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
