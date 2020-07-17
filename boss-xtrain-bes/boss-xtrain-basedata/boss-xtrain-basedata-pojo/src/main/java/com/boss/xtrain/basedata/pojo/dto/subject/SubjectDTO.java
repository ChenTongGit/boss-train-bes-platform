package com.boss.xtrain.basedata.pojo.dto.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SubjectDTO extends BaseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectTypeId;
    private String subjectTypeName;
    private String categoryName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    private String difficulty;
    private String imageUrl;
    private String remark;
    private BigDecimal score;
    private List<SubjectAnswer> subjectAnswers;
}
