package com.boss.xtrain.paper.dto.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 根据组卷配置ID组卷对象
 * @author lenovo
 */
@Data
public class CombConfigItemQueryDTO extends BaseDTO {
    /**
     * 组卷配置ID
     */
    @NotBlank(message = "组卷配置ID不能为空")
    private Long id;
    /**
     * 试卷名
     */
    @NotBlank(message = "试卷名能为空")
    private String paperName;
    /**
     * 试卷描述
     */
    private String discript;
    /**
     * 试卷难度
     */
    @NotBlank(message = "试卷难度能为空")
    private Long difficulty;
    /**
     * 试卷类型
     */
    @NotBlank(message = "试卷类型能为空")
    private Long paperType;
    /**
     * 组卷人
     */
    @NotBlank(message = "试卷类型不能为空")
    private String combExamMan;
    /**
     * 所属公司
     */
    private Long company;
}

