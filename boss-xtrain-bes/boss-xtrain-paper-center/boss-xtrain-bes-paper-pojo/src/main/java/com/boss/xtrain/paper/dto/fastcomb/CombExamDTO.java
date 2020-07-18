package com.boss.xtrain.paper.dto.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.util.List;

/**
 * 组卷信息对象
 * @author lenovo
 */
@Data
public class CombExamDTO extends BaseDTO {
    private String paperName;
    /**
     * Description: 配置明细
     */
    private List<ConfigItemDTO> itemList;
    /**
     * Description: 试卷描述
     */
    private String discript;
    /**
     * Description: 试卷难度
     */
    private Long difficulty;
    /**
     * Description: 试卷类型
     */
    private Long paperType;
    /**
     * Description: 组卷人
     */
    private String combExamMan;
    /**
     * Description: 所属公司
     */
    private Long company;
}

