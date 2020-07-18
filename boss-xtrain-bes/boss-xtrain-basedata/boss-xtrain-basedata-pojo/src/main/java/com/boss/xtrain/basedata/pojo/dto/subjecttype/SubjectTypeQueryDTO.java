package com.boss.xtrain.basedata.pojo.dto.subjecttype;

import lombok.Data;

import java.util.Date;

@Data
public class SubjectTypeQueryDTO {
    private Long orgId;
    private String name;
    private int pageNum;
    private int pageSize;
    private Date updatedTime;

}
