package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CombExamItemDTO implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String subjectTypeName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectTypeId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long combExamConfigId;
    private String categoryName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    private Long difficulty;
    private String difficultyName;
    private Integer num;
    private BigDecimal score;
}
