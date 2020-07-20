package com.boss.xtrain.basedata.api.paper;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConfigItemDTO extends BaseDTO {
    private Long configExamConfigId;
    private Long categoryId;
    private Long subjectTypeId;
    private Integer num;
    private Long difficulty;
    private BigDecimal score;
    private String categoryName;
    private String typeName;
    private String difficultName;
}
