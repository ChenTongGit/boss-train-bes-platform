package com.boss.bes.paper.vo.paperdetail;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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

    public Date getCombExamTime() {
        if (combExamTime == null){
            return null;
        }
        return (Date)combExamTime.clone();
    }

    public void setCombExamTime(Date combExamTime) {
        if (combExamTime == null){
            this.combExamTime = null;
        }else {
            this.combExamTime = (Date)combExamTime.clone();
        }
    }
}

