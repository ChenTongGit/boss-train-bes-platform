package com.boss.xtrain.exam.pojo.dto.query;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;

/**
 * 阅卷查询条件
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/14 6:49
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class MarkingQuery {
    /**
     * 批阅状态
     */
    private Integer status;

    /**
     * 交卷时间开始点
     */
    private Date leftHandInTime;

    /**
     * 交卷时间结束点
     */
    private Date rightHandInTime;

    /**
     * 考试场次
     */
    private String examSession;

    private Long markPeople;

    public String getExamSession() {
        return examSession;
    }

    public void setExamSession(String examSession) {
        this.examSession = examSession;
    }

    public Long getMarkPeople() {
        return markPeople;
    }

    public void setMarkPeople(Long markPeople) {
        this.markPeople = markPeople;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLeftHandInTime() {
        return leftHandInTime;
    }

    public void setLeftHandInTime(Date leftHandInTime) {
        this.leftHandInTime = leftHandInTime;
    }

    public Date getRightHandInTime() {
        return rightHandInTime;
    }

    public void setRightHandInTime(Date rightHandInTime) {
        this.rightHandInTime = rightHandInTime;
    }
}
