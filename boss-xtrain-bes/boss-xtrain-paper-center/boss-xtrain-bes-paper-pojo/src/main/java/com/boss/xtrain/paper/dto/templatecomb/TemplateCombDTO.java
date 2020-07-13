package com.boss.xtrain.paper.dto.templatecomb;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**模板组卷对象
 * @author lenovo
 */
@Data
public class TemplateCombDTO extends BaseDTO {
    /**
     * 模板id
     */
    private Long paperId;
    /**
     * 用户名（组卷人）
     */
    private String combExamMan;
    /**
     * 试卷描述
     */
    private String discript;
    /**
     * 试卷名
     */
    private String paperName;
    /**
     * 试卷类型
     */
    private Long paperType;
    /**
     * 试卷难度
     */
    private Long difficulty;
    /**
     * 所属公司
     */
    private Long company;
}

