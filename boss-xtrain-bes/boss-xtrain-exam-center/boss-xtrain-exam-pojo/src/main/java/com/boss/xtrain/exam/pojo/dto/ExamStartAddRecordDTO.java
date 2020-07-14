package com.boss.xtrain.exam.pojo.dto;

/**
 * 考试考试初次添加考试记录dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 15:18
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamStartAddRecordDTO {

    /**
     * 考试发布记录id
     */
    private Long publishId;

    /**
     * 考生id
     */
    private Long examPeople;

    public ExamStartAddRecordDTO() {
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getExamPeople() {
        return examPeople;
    }

    public void setExamPeople(Long examPeople) {
        this.examPeople = examPeople;
    }
}
