package com.boss.xtrain.exam.pojo.dto.query;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author ChenTong
 * @date 2020/7/14 7:28
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ReportDetailQuery {

    /**
     * 考试发布记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long publishId;

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }
}
