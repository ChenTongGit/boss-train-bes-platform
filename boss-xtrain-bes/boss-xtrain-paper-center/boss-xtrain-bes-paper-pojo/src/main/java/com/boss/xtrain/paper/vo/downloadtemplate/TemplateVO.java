package com.boss.xtrain.paper.vo.downloadtemplate;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 模板对象
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
     * 下载次数
     */
    private Integer downloadTimes;
}
