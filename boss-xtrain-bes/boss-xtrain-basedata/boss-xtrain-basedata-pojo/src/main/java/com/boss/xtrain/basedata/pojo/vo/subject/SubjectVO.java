package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectVO extends BaseVO {
    private String name;
    private Long subjectTypeId;
    private Long categoryId;
    private Long difficulty;
    private String remark;
    private String difficultyName;
    private String subjectTypeName;
    private String categoryName;
    private String subjectName;
    private String imageUrl;
    private BigDecimal score;
    private List<SubjectAnswer> subjectAnswers;

}
