package com.boss.xtrain.basedata.pojo.dto.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SubjectUpdateDTO extends BaseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String subjectTypeName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectTypeId;
    private String categoryName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    private String difficulty;
    private String name;
    private String imageUrl;
    private String remark;
    private String field1;
    private String field2;
    private String field3;
    private List<SubjectAnswer> subjectAnswers;

    public List<SubjectAnswer> getSubjectAnswers() {
        return subjectAnswers;
    }

    @JsonProperty(value = "subjectAnswers")
    public void setSubjectAnswers(List<SubjectAnswer> subjectAnswers) {
        this.subjectAnswers = subjectAnswers;
    }
}
