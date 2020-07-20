package com.boss.xtrain.exam.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 阅卷人员列表
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/20 13:16
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class MarkUserListVO {
    /**
     * 姓名
     */
    private String name;

    /**
     * 阅卷官id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
