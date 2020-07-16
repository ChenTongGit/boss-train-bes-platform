package com.boss.xtrain.basedata.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_subject_answer")
public class SubjectAnswer extends BaseEntity implements Serializable {

    /**
     * 题目ID
     */
    @Column(name = "t_s_id")
    private Long subjectId;

    /**
     * 答案
     */
    @Column(name = "answer")
    private String answer;

    /**
     * 正确答案
     */
    @Column(name = "right_answer")
    private Byte rightAnswer;

    /**
     * 图片路径
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 保留字段1
     */
    @Column(name = "field1")
    private String field1;

    /**
     * 保留字段2
     */
    @Column(name = "field2")
    private String field2;

    /**
     * 保留字段3
     */
    @Column(name = "field3")
    private String field3;

    private static final long serialVersionUID = 1L;

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

    public Byte getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Byte rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}