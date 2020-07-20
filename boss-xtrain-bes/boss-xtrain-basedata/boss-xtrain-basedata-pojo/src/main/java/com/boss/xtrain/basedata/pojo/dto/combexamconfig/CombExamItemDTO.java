package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CombExamItemDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String subjectTypeName;
    private Long subjectTypeId;
    private Long combExamConfigId;
    private String categoryName;
    private Long categoryId;
    private Long difficulty;
    private String difficultyName;
    private Integer num;
    private BigDecimal score;
}
