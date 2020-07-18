package com.boss.xtrain.exam.pojo.dto.query;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 考生查询query封装
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 23:43
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPeopleQuery extends BaseQuery {
    /**
     * 考生手机号
     */
    private String mobile;

    /**
     * 考生id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
