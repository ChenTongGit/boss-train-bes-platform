package com.boss.xtrain.basedata.pojo.vo.combexamitem;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CombExamItemVO extends BaseVO {
    private Long id;
    private Integer num;
    private Long difficulty;
    private BigDecimal score;
    private Long subjectTypeId;
    private Long categoryId;
    private Long combExamConfigId;
    private String subjectTypeName;
    private String categoryName;
    private String combExamConfigName;
    private String difficultyName;

}
