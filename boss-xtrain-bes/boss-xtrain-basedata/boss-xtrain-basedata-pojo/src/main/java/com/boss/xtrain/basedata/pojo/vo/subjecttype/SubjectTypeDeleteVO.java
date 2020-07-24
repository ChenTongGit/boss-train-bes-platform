package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author gxr
 * @description 题目类别删除VO
 * @date 2020/7/6
 */
@Data
public class SubjectTypeDeleteVO{
    /**
     * 题型id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 题型版本
     */
    private Long version;
}
