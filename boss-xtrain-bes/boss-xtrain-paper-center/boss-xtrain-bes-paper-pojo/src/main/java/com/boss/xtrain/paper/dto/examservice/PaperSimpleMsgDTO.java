package com.boss.xtrain.paper.dto.examservice;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class PaperSimpleMsgDTO {
    /**
     * 试卷ID
     */
    private Long paperId;
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


    public Date getCombExamTim() {
        if (combExamTim == null){
            return null;
        }
        return (Date)combExamTim.clone();
    }

    public void setCombExamTim(Date combExamTime) {
        if (combExamTime == null){
            this.combExamTim = null;
        }else {
            this.combExamTim = (Date)combExamTime.clone();
        }
    }
}
