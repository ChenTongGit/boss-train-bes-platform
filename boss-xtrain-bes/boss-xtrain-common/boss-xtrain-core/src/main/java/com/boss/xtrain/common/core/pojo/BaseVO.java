package com.boss.xtrain.common.core.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @class BaseVO
 * @classdesc 抽象界面显示的公用信息
 *
 * @author Administrator
 * @date 2020-6-19  11:01
 * @version 1.0.0
 * @see
 * @since
 */
public abstract class BaseVO implements Serializable {
    public static final long serialVersionUID = 443243264652L;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    

    public BaseVO() {
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "createBy='" + createBy + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
