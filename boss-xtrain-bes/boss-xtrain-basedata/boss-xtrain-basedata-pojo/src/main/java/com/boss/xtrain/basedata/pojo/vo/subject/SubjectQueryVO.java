package com.boss.xtrain.basedata.pojo.vo.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


/**
 * @author gxr
 * @description 题目查询VO
 * @date 2020/7/6
 */
@Data
public class SubjectQueryVO{
    private String categoryName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    private String subjectTypeName;
    private String name;
    private Long orgId;
    private Long companyId;
}
