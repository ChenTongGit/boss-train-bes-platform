package com.boss.xtrain.basedata.pojo.dto.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class SubjectUpdateDTO extends BaseDTO {
    private Long id;
    private Long subjectTypeId;
    private Long categoryId;
    private Long difficulty;
    private String subjectName;
    private String imageUrl;
    private String remark;
    private String field1;
    private String field2;
    private String field3;
    private List<SubjectAnswer> subjectAnswers;
}
