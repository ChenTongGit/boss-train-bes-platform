package com.boss.xtrain.basedata.pojo.dto.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

@Data
public class SubjectTypeUpdateDTO extends BaseEntity {
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
