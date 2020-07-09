package com.boss.bes.paper.vo.downloadtemplate;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**下载模板对象
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
     * 试卷描述
     */
    @Size(max = 128,message = "试卷描述不能超过128个字符")
    private String discript;
    /**
     * 试卷名
     */
    @NotBlank(message = "试卷名不能为空")
    @Size(max = 32,message = "试卷名不能超过32个字符")
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
    private String difficulty;
    /**
     * 所属公司
     */
    @NotBlank(message = "所属公司不能为空")
    private String company;
}

