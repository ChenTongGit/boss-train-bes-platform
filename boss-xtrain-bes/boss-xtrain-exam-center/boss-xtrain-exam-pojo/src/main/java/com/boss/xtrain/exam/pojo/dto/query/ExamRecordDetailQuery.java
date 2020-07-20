package com.boss.xtrain.exam.pojo.dto.query;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.NotNull;

/**
 * 考试记录详情query
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/13 21:10
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamRecordDetailQuery {
    /**
     * 考试记录id
     */
    @NotNull(message = "考试记录id不能为空")
    private Long examRecordId;

    /**
     * 试卷id
     */
    @NotNull(message = "试卷id不能为空")
    private Long paperId;

    public Long getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }
}
