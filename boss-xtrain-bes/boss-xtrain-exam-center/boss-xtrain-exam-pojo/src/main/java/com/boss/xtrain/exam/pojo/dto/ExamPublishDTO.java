package com.boss.xtrain.exam.pojo.dto;

import javax.validation.constraints.NotNull;

/**
 * 试卷发布传输dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 18:39
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPublishDTO {
    /**
     * 所要发布考试记录id
     */
    @NotNull(message = "考试发布记录id不能为空")
    private Long id;

    /**
     * 所要发布的试卷id
     */
    @NotNull(message = "要发布的试卷id不能为空")
    private Long paperId;

    /**
     * 发布状态
     */
    @NotNull(message = "考试发布记录状态不能为空")
    private Integer status;

    /**
     * 版本号
     */
    @NotNull(message = "数据版本号不能为空")
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }
}
