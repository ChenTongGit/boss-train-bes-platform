package com.boss.xtrain.basedata.pojo.dto.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SubjectDTO extends BaseDTO {
    private Long id;
    private String name;
    private Long subjectTypeId;
    private String subjectTypeName;
    private String categoryName;
    private Long categoryId;
    private Long difficulty;
    private String subjectName;
    private String difficultyName;
    private String imageUrl;
    private String remark;
    private BigDecimal score;
    private List<SubjectAnswer> subjectAnswers;
}
