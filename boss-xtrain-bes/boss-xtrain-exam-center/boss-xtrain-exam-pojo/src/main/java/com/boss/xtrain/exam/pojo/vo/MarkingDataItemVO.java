package com.boss.xtrain.exam.pojo.vo;

import java.math.BigDecimal;

/**
 * 阅卷每道题明细的vo
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/19 14:49
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class MarkingDataItemVO {
    /**
     * 答案记录id
     */
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
