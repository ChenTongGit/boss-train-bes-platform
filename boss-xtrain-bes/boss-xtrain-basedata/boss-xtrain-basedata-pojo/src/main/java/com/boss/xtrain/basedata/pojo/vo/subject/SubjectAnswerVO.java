package com.boss.xtrain.basedata.pojo.vo.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gxr
 * @description 题目答案VO
 * @date 2020/7/6
 */
@Data
public class SubjectAnswerVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 题目答案id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 正确答案
     */
    private Integer rightAnswer;
    /**
     * 全部答案
     */
    private String answer;
    /**
     * 图片路径
     */
    private String imageUrl;
    /**
     * 对应题目id
     */
    private Long subjectId;
    /**
     * 难度
     */
    private String difficulty;
    /**
     * 对应题目名称
     */
    private String subjectName;
    /**
     * 对应题目类别名称
     */
    private String subjectTypeName;

}
