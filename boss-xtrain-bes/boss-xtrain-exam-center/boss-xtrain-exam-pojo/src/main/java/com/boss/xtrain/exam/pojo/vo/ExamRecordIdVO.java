package com.boss.xtrain.exam.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 考试记录idvo
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/17 17:10
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamRecordIdVO {

    /**
     * 考试记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long examRecordId;

    public Long getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }
}
