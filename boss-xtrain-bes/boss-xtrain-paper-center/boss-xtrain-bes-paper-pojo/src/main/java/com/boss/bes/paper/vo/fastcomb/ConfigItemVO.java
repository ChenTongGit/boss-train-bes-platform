package com.boss.bes.paper.vo.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class ConfigItemVO extends BaseVO {
    /**
     * 配置项ID
     */
    private String combExamConfigId;
    /**
     * 题目类型
     */
    @NotBlank(message = "题目类型不能为空")
    private String categoryId;
    /**
     * 题型ID
     */
    @NotBlank(message = "题型ID不能为空")
    private String subjectTypeId;
    /**
     * 数量
     */
    @NotBlank(message = "题目数量不能为空")
    private Integer num;
    /**
     * 难度
     */
    @NotBlank(message = "题目难度不能为空")
    private String difficulty;
    /**
     * 分值
     */
    @NotBlank(message = "题目分数不能为空")
    private BigDecimal score;
    /**
     * 题目类别名字
     */
    private String categoryName;
    /**
     * 题型名字
     */
    private String typeName;
    /**
     * 难度名
     */
    private String difficultyName;

}

