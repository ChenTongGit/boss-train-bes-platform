package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CombExamItemDTO {
    private Long id;
    private String subjectTypeName;
    private Long subjectTypeId;
    private Long configId;
    private String categoryName;
    private Long categoryId;
    private Long difficulty;
    private Integer num;
    private BigDecimal score;
}
