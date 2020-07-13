package com.boss.xtrain.paper.dto.conditionquerypaper;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.util.Date;

/**试卷查询
 * @author lenovo
 */
@Data
public class QueryPaperDTO extends BaseDTO {
    /**
     * 试卷名
     */
    private String paperName;
    /**
     * 组卷人
     */
    private String combExamMan;
    /**
     * 试卷类型
     */
    private Long paperType;
    /**
     * 试卷难度
     */
    private Long difficuty;
    /**
     * 日期开始时间
     */
    private Date beginTime;
    /**
     * 日期结束时间
     */
    private Date endTime;
    /**
     * 模板标记
     */
    private Boolean template;
}

