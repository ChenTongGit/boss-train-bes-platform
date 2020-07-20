package com.boss.xtrain.exam.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;

/**
 * 考试报表vo
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/14 7:23
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ReportDataListVO {

    /**
     * 考试发布记录Id，用于关联查询
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long publishRecordId;

    /**
     * 考试标题
     */
    private String title;


    /**
     * 考试截止时间（计划）
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 计划考试人数
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Integer planPeopleNum;

    /**
     * 实际考试人数
     */
    private Integer actualPeopleNum;

    public Long getPublishRecordId() {
        return publishRecordId;
    }

    public void setPublishRecordId(Long publishRecordId) {
        this.publishRecordId = publishRecordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPlanPeopleNum() {
        return planPeopleNum;
    }

    public void setPlanPeopleNum(Integer planPeopleNum) {
        this.planPeopleNum = planPeopleNum;
    }

    public Integer getActualPeopleNum() {
        return actualPeopleNum;
    }

    public void setActualPeopleNum(Integer actualPeopleNum) {
        this.actualPeopleNum = actualPeopleNum;
    }
}
