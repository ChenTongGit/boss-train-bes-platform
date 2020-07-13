package com.boss.xtrain.paper.vo.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**模板对象
 * @author lenovo
 */
@Data
public class TemplateVO extends BaseVO {
    /**
     * 模板ID
     */
    private String paperId;
    /**
     * 模板名
     */
    private String paperName;
    /**
     * 组卷人
     */
    private String combExamMan;
    /**
     * 试卷类型
     */
    private String paperType;
    /**
     * 试卷难度
     */
    private String difficulty;
    /**
     * 组卷时间
     */
    private Date combExamTime;
    /**
     * 试卷总分
     */
    private BigDecimal score;
    /**
     * 试卷描述
     */
    private String discript;



}

