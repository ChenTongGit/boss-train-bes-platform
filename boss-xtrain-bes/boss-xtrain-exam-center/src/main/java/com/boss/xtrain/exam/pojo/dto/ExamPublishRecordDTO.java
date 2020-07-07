package com.boss.xtrain.exam.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;

import java.util.Date;

/**
 * 考试发布记录添加dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 18:46
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPublishRecordDTO extends BaseDTO {
    /**
     * 发布考试标题
     */
    private String title;

    /**
     * 发布用户id
     */
    private Long publisher;

    /**
     * 考试开始时间
     */
    private Date startTime;

    /**
     * 考试结束时间
     */
    private Date endTime;

    /**
     * 计划参与考试人员
     */
    private Integer planPeopleNum;

    /**
     * 考试说明
     */
    private String description;

    /**
     * 阅卷方式
     */
    private Integer markMode;


}
