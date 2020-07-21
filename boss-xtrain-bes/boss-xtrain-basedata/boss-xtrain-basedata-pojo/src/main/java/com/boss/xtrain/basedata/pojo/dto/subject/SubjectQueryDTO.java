package com.boss.xtrain.basedata.pojo.dto.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SubjectQueryDTO {
    private String name;
    private String subjectTypeName;
    private String categoryName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    private Long orgId;
}
