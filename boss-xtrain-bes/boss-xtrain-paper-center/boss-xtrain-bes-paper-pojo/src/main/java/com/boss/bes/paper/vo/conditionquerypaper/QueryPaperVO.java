package com.boss.bes.paper.vo.conditionquerypaper;

import com.boss.xtrain.common.core.pojo.BaseQuery;
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
    private String difficulty;
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
    @NotBlank(message = "模板标记不能为空")
    private Byte template;
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

