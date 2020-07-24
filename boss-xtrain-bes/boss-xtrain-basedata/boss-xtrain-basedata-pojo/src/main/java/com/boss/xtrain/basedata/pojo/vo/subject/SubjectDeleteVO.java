package com.boss.xtrain.basedata.pojo.vo.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author gxr
 * @description 题目删除VO
 * @date 2020/7/6
 */
@Data
public class SubjectDeleteVO{
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Long version;
}
