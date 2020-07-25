package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author gxr
 * @description 题目更新VO
 * @date 2020/7/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectUpdateVO extends BaseVO {
    /**
     * 题目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 题型名称
     */
    @NotBlank(message = "题型不能为空")
    private String subjectTypeName;
    /**
     * 题型id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectTypeId;
    /**
     * 题目类别名称
     */
    @NotBlank(message = "题目类别不能为空")
    private String categoryName;
    /**
     * 题目类别id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    /**
     * 题目名称
     */
    @NotBlank(message = "题目名称不能为空")
    private String name;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 题目难度
     */
    @NotBlank(message = "难度不能为空")
    private String difficulty;
    /**
     * 图片路径
     */
    private String imageUrl;
    /**
     * 图片备注
     */
    private String remark;
    /**
     * 题目答案
     */
    private List<SubjectAnswer> subjectAnswers;
}
