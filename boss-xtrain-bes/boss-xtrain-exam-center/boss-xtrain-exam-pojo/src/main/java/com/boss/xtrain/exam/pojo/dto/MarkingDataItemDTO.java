package com.boss.xtrain.exam.pojo.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 考试阅卷结果
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/16 14:48
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class MarkingDataItemDTO {

    /**
     * 答案记录id
     */
    @NotNull(message = "考试答案记录id不能为空")
    private Long id;

    /**
     * 试题id
     */
    private Long subjectId;

    /**
     * 得分
     */
    private BigDecimal score;

    /**
     * 评价
     */
    private String evaluate;

    /**
     * 版本号
     */
    @NotNull(message = "更新版本号不能为空")
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
