package com.boss.xtrain.paper.vo.papermanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**试卷对象
 * @author lenovo
 */
@Data
public class PaperVO extends BaseVO {
    /**
     * 试卷ID
     */
    private String paperId;
    /**
     * 试卷名
     */
    private String paperName;
    /**
     * 组卷人
     */
    private String combExamMa;
    /**
     * 试卷类型
     */
    private String paperType;
    /**
     * 试卷难度
     */
    private String difficuty;
    /**
     * 组卷时间
     */
    private Date combExamTim;
    /**
     * 试卷总分
     */
    private BigDecimal score;
    /**
     * 试卷描述
     */
    private String discript;


}
