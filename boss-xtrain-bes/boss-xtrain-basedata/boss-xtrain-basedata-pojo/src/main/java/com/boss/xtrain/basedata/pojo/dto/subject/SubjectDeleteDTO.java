package com.boss.xtrain.basedata.pojo.dto.subject;

import lombok.Data;

@Data
public class SubjectDeleteDTO{
    private Long id;
    private String name;
    private Boolean status;
    private Long orgId;
    private Long companyId;
    private Long version;
}
