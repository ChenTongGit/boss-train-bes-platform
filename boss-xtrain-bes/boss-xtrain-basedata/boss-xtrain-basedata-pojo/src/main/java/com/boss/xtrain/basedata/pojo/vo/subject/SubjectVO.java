package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectTypeId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    private String remark;
    private String difficulty;
    private String subjectTypeName;
    private String categoryName;
    private String name;
    private String imageUrl;
    private BigDecimal score;
    private List<SubjectAnswer> subjectAnswers;

}
