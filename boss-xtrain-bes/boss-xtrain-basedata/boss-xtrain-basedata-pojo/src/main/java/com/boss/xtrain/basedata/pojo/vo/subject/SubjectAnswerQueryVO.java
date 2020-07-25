package com.boss.xtrain.basedata.pojo.vo.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author gxr
 * @description 题目答案查询VO
 * @date 2020/7/6
 */
@Data
public class SubjectAnswerQueryVO {
    /**
     * 题目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectId;
}
