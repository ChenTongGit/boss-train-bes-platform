package com.boss.xtrain.exam.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 手机答卷显示基础考试信息
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 12:18
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamBasicInfoVO extends BaseVO {

    /**
     * 考试标题
     */
    private String title;

    /**
     * 试卷id
     */
    private Long paperId;

    /**
     * 考试开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 考试结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 考试说明
     */
    private String description;

    /**
     * 限制时间
     */
    private Integer limitTime;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }
}
