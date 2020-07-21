package com.boss.xtrain.permission.pojo.dto;

/**
 * 考试服务需要dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/20 12:17
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamServiceUsersDTO {
    private Long userId;
    private String name;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
