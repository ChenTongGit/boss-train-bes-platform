package com.boss.xtrain.basedata.pojo.dto.subjecttype;

import lombok.Data;

@Data
public class SubjectTypeDeleteDTO {
    /**
     * 题型ID
     */
    private Long id;
    /**
     * 题型名称
     */
    private String subjectName;
    /**
     * 状态位
     */
    private Integer status;
    /**
     * 机构ID
     */
    private Long orgId;
    /**
     * 版本
     */
    private Long version;
}
