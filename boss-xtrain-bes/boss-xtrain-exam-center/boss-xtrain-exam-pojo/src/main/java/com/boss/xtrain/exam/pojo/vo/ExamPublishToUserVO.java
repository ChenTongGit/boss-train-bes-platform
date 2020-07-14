package com.boss.xtrain.exam.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * 阅卷关系dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 11:28
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPublishToUserVO implements Serializable {
    /**
     * 阅卷官的姓名
     */
    private String name;

    /**
     * 阅卷官id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long markPeople;

    public ExamPublishToUserVO() {
        // 构造函数
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMarkPeople() {
        return markPeople;
    }

    public void setMarkPeople(Long markPeople) {
        this.markPeople = markPeople;
    }
}
