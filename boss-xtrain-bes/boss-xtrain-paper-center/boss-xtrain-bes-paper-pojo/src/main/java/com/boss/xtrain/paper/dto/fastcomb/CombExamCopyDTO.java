package com.boss.xtrain.paper.dto.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**试卷信息拷贝对象
 * @author lenovo
 */
@Data
public class CombExamCopyDTO extends BaseDTO {
    /**
     * Description: 试卷名
     */
    private String paperName;
    /**
     * Description: 试卷描述
     */
    private String discript;
    /**
     * Description: 试卷难度
     */
    private Long difficuty;
    /**
     * Description: 试卷类型
     */
    private Long paperType;
    /**
     * Description: 组卷人
     */
    private String combExamMa;
}

