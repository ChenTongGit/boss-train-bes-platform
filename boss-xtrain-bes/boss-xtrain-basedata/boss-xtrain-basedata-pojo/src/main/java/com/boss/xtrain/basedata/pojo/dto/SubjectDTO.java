package com.boss.xtrain.basedata.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SubjectDTO extends BaseEntity {
    private Long id;
    private String name;
    private Long subjectTypeId;
    private Long categoryId;
    private String imageUrl;
    private String remark;
    private String field1;
    private String field2;
    private String field3;
}
