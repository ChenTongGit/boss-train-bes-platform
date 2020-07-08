package com.boss.xtrain.basedata.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SubjectAnswerDTO extends BaseEntity {
    private Long id;
    private String answer;
    private Long subjectId;
    private String imageUrl;
    private String rightAnswer;
    private String field1;
    private String field2;
    private String field3;
}
