package com.boss.xtrain.paper.vo.standardcomb;

import com.boss.xtrain.paper.vo.fastcomb.ConfigItemVO;
import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class StandardCombVO extends BaseVO {
    /**
     * Description: 配置名称
     */
    @NotBlank(message = "配置名称不能为空")
    @Length(max = 32,message = "配置项名不能超过32个字符")
    private String combConfigName;
    /**
     * Description: 状态
     */
    @NotBlank(message = "状态不能为空")
    private Boolean paperStatus;
    /**
     * Description: 试卷名
     */
    @NotBlank(message = "试卷名不能为空")
    @Length(max = 32,message = "试卷名不能超过32个字符")
    private String paperName;
    /**
     * Description: 配置明细
     */
    @NotBlank(message = "配置明细不能为空")
    private List<ConfigItemVO> itemList;
    /**
     * Description: 试卷描述
     */
    @Length(max = 128,message = "试卷描述不能超过128个字符")
    private String discript;
    /**
     * Description: 试卷难度
     */
    @NotBlank(message = "试卷难度不能为空")
    private String difficulty;
    /**
     * Description: 试卷类型
     */
    @NotBlank(message = "试卷类型不能为空")
    private String paperType;
    /**
     * Description: 组卷人
     */
    @NotBlank(message = "组卷人不能为空")
    @Length(max = 32,message = "组卷人名不能超过32个字符")
    private String combExamMan;
    /**
     * Description: 所属公司
     */
    @NotBlank(message = "所属公司不能为空")
    private String company;
}

