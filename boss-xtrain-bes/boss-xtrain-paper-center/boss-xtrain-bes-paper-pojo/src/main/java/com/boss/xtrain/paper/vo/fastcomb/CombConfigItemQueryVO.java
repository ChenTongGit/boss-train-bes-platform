package com.boss.xtrain.paper.vo.fastcomb;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**查询组卷明细，以及生成试卷的基本信息对象
 * @author lenovo
 */
@Data
public class CombConfigItemQueryVO extends BaseVO {
    /**
     * 组卷配置ID
     */
    @NotBlank(message = "组卷配置ID不能为空")
    private String combPaperId;
    /**
     * 试卷名
     */
    @NotBlank(message = "试卷名不能为空")
    @Length(max = 32,message = "试卷名不能超过32个字符")
    private String paperName;
    /**
     * 试卷描述
     */
    @Length(max = 128,message = "试卷描述不能超过128个字符")
    private String discript;
    /**
     * 试卷难度
     */
    @NotBlank(message = "试卷难度不能为空")
    private String difficulty;
    /**
     * 试卷类型
     */
    @NotBlank(message = "试卷类型不能为空")
    private String paperType;
    /**
     * 组卷人
     */
    @NotBlank(message = "组卷人不能为空")
    @Length(max = 32,message = "组卷人名不能超过32个字符")
    private String combExamMan;
    /**
     * Description: 所属公司
     */
    private String company;
}

