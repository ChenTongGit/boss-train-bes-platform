package com.boss.xtrain.paper.dto.standardcomb;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.paper.dto.fastcomb.ConfigItemDTO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**标准组卷对象
 * @author lenovo
 */
@Data
public class StandardCombDTO extends BaseDTO {
    /**
     * Description: 配置名称
     */
    @NotBlank(message = "配置名称不能为空")
    @Length(max = 32,message = "配置名称不能超过32个字符")
    private String combConfigName;
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
    private List<ConfigItemDTO> itemList;
    /**
     * Description: 试卷描述
     */
    @Length(max = 128,message = "试卷描述不能超过128字符")
    private String discript;
    /**
     * Description: 试卷难度
     */
    @NotBlank(message = "试卷难度不能为空")
    private Long difficulty;
    /**
     * Description: 试卷类型
     */
    @NotBlank(message = "试卷类型不能为空")
    private Long paperType;
    /**
     * Description: 组卷人
     */
    @NotBlank(message = "组卷人不能为空")
    @Length(max = 32,message = "组卷人名不能超过32个字符")
    private String combExamMan;
    /**
     * Description: 所属公司
     */
    private Long company;
}

