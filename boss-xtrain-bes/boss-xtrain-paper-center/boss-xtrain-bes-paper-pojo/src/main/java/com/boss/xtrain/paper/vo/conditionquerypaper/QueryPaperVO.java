package com.boss.xtrain.paper.vo.conditionquerypaper;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 条件查询试卷对象
 */
@Data
public class QueryPaperVO extends BaseQuery {

    /**
     * 公司ID
     */
    private String companyId;
    /**
     * 组织机构ID
     */
    private String orgId;
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
    private String difficuty;
    /**
     * 日期开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;
    /**
     * 日期结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    /**
     * 模板标记
     */
    @NotBlank(message = "模板标记不能为空")
    private Boolean template;
    public Date getBeginTime() {
        if (beginTime == null){
            return null;
        }
        return (Date)beginTime.clone();
    }

    public void setBeginTime(Date beginTime) {
        if (beginTime == null){
            this.beginTime = null;
        }else {
            this.beginTime = (Date)beginTime.clone();
        }
    }

    public Date getEndTime() {
        if (endTime == null){
            return null;
        }
        return (Date)endTime.clone();
    }

    public void setEndTime(Date endTime) {
        if (endTime == null){
            this.endTime = null;
        }else {
            this.endTime = (Date)endTime.clone();
        }
    }
}

