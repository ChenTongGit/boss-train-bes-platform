package com.boss.xtrain.basedata.pojo.vo.combexamitem;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CombExamItemVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Integer num;
    private Long difficulty;
    private BigDecimal score;
    private String subjectTypeId;
    private String categoryId;
    private String combExamConfigId;
    private String subjectTypeName;
    private String categoryName;
    private String combExamConfigName;
    private String difficultyName;

}
