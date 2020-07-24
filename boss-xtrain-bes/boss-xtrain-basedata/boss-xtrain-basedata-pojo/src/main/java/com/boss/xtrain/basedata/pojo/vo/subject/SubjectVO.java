package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gxr
 * @description 题目VO
 * @date 2020/7/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectVO extends BaseVO {
    /**
     * 题目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 题目类型id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectTypeId;
    /**
     * 题目类型id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 难度
     */
    private String difficulty;
    /**
     * 题型名称
     */
    private String subjectTypeName;
    /**
     * 题目类型名称
     */
    private String categoryName;
    /**
     * 题目名称
     */
    private String name;
    /**
     * 图片路径
     */
    private String imageUrl;
    /**
     * 分数
     */
    private BigDecimal score;
    /**
     * 题目答案
     */
    private List<SubjectAnswer> subjectAnswers;

}
