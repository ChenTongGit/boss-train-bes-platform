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
     * 主键id
     */
    private Long id;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 记录所属公司ID
     */
    private Long companyId;

    /**
     * 组织机构ID ，一个组织机构包含多个公司
     */
    private Long organizationId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    private Date createdTime;

    /**
     *  创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    private Long createdBy;

    /**
     *  更新时间记录便于追踪
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;

    /**
     * 更新人id
     */
    private Long updatedBy;
    /**
     * 版本
     */
    private Long version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 备注
     */
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    

    public BaseVO() {
    }


}
