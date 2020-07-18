package com.boss.xtrain.paper.dto.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 组卷配置明细对象
 * @author lenovo
 */
@Data
public class ConfigItemDTO extends BaseDTO {
    /**
     * 配置项ID
     */
    private Long combExamConfigId;
    /**
     * 题目类型
     */
    private Long categoryId;
    /**
     * 题型ID
     */
    private Long subjectTypeId;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 难度
     */
    private Long difficuty;
    /**
     * 分值
     */
    private BigDecimal score;
    /**
     * 题目类别名字
     */
    private String categoryName;
    /**
     * 题型名字
     */
    private String typeName;
    /**
     * 难度名
     */
    private String difficutyName;
}

