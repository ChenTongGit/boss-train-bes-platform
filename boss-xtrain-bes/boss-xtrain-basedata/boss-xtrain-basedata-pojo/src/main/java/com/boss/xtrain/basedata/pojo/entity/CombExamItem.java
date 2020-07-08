package com.boss.xtrain.basedata.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_comb_exam_config_item")
public class CombExamItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组卷配置明细项ID
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 题目类别ID
     */
    @Column(name = "t_s_id")
    private Long subjectTypeId;

    /**
     * 题型ID
     */
    @Column(name = "t_c_id")
    private Long categoryId;

    /**
     * 组卷ID
     */
    @Column(name = "t_c_id2")
    private Long combExamConfigId;

    /**
     * 数量
     */
    @Column(name = "num")
    private Integer num;

    /**
     * 难度
     */
    @Column(name = "difficult")
    private Long difficult;

    /**
     * 分值
     */
    @Column(name = "score")
    private BigDecimal score;

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Long getDifficult() {
        return difficult;
    }

    public void setDifficult(Long difficult) {
        this.difficult = difficult;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getCombExamConfigId() {
        return combExamConfigId;
    }

    public void setCombExamConfigId(Long combExamConfigId) {
        this.combExamConfigId = combExamConfigId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    @Override
    public String toString() {
        return "CombExamItem{" +
                "id=" + id +
                ", subjectTypeId=" + subjectTypeId +
                ", categoryId=" + categoryId +
                ", combExamConfigId=" + combExamConfigId +
                ", num=" + num +
                ", difficult=" + difficult +
                ", score=" + score +
                '}';
    }
}