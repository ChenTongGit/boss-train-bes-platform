package com.boss.xtrain.basedata.pojo.dto.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SubjectTypeUpdateDTO extends BaseEntity {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 题型名称
     */
    private String subjectName;
    /**
     * 属性列
     */
    private String attribute;
    /**
     * 备注
     */
    private String remark;
}
