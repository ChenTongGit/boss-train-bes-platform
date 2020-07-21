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
@Data
public class CombExamItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 题型ID
     */
    @Column(name = "t_s_id")
    private Long subjectTypeId;

    /**
     * 题目类别ID
     */
    @Column(name = "t_c_id2")
    private Long categoryId;

    /**
     * 组卷ID
     */
    @Column(name = "t_c_id")
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
    private Long difficulty;

    /**
     * 分值
     */
    @Column(name = "score")
    private BigDecimal score;

}