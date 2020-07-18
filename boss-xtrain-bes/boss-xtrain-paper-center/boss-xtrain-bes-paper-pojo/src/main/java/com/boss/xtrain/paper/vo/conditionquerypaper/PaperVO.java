package com.boss.xtrain.paper.vo.conditionquerypaper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lenovo
 * 试卷接收对象
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperVO
{
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
    /**
     * 状态
     */
    private Boolean status;


}
