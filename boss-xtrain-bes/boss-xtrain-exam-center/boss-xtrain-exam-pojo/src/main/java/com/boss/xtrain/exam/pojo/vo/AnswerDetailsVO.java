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
    private Long id;

    /**
     * 对应的试题id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectId;

    /**
     * 答案内容
     */
    private String answer;

    /**
     * 图片路径
     */
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaperSubjectId() {
        return paperSubjectId;
    }

    public void setPaperSubjectId(Long paperSubjectId) {
        this.paperSubjectId = paperSubjectId;
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
