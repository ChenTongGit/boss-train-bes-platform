package com.boss.xtrain.basedata.pojo.dto.subject;

import lombok.Data;

@Data
public class SubjectQueryDTO {
    private String name;
    private String subjectTypeName;
    private String categoryName;
    private Long orgId;
}
