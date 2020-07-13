package com.boss.xtrain.exam.pojo.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 发布记录删除使用
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 17:43
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPublishDeleteDTO implements Serializable {
    private static final long serialVersionUID = 455424324322L;
    /**
     * 删除所需id
     */
    @NotNull(message = "考试发布记录id不能为空")
    Long id;

    /**
     * 发布状态
     */
    @NotNull(message = "考试状态不能为空")
    Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExamPublishDeleteDTO{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
