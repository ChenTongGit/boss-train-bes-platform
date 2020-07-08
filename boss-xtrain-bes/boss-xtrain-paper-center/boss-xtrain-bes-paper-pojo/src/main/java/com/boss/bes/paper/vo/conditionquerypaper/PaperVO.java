package com.boss.bes.paper.vo.conditionquerypaper;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lenovo
 * 试卷接收对象
 */
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
    /**
     * 状态
     */
    private Byte status;


}
