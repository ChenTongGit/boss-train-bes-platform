package com.boss.xtrain.basedata.pojo.dto.subjecttype;

import lombok.Data;

@Data
public class SubjectTypeQueryDTO {
    private Long orgId;
    private String name;
    private int pageIndex;
    private int pageSize;
    private String orderBy;

}
