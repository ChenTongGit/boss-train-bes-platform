package com.boss.xtrain.basedata.pojo.dto.subject;

import lombok.Data;

@Data
public class SubjectQueryDTO {
    private Long id;
    private String name;
    private Long subjectTypeId;
    private Long categoryId;
    private String subjectTypeName;
    private String categoryName;
    private Long orgId;
    private Long companyId;
}
