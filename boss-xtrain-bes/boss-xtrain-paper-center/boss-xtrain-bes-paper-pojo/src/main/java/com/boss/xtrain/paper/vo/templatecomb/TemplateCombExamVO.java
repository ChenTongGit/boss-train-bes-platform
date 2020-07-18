package com.boss.xtrain.paper.vo.templatecomb;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**生成试卷
 * @author lenovo
 */
@Data
public class TemplateCombExamVO extends BaseVO {
    /**
     * 模板id
     */
    @NotBlank(message = "模板id不能为空")
    private String paperId;
    /**
     * 用户名（组卷人）
     */
    @NotBlank(message = "组卷人名不能为空")
    @Length(max = 32,message = "组卷人名不能超过32个字符")
    private String combExamMa;
    /**
     * 试卷描述
     */
    @Length(max = 128,message = "试卷描述不能超过128个字符")
    private String discript;
    /**
     * 试卷名
     */
    @NotBlank(message = "试卷名不能为空")
    @Length(max = 32,message = "试卷名不能超过32个字符")
    private String paperName;
    /**
     * 试卷类型
     */
    @NotBlank(message = "试卷类型不能为空")
    private String paperType;
    /**
     * 试卷难度
     */
    @NotBlank(message = "试卷难度不能为空")
    private String difficuty;
    /**
     * 所属公司
     */
    private String company;

}

