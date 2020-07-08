package com.boss.xtrain.basedata.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class CombExamItemDTO extends BaseEntity {
    private Long id;
    private Integer difficult;
    private BigDecimal score;
    private Long subjectTypeId;
    private Long categoryId;
    private Long combExamConfigId;
}
