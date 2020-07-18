package com.boss.xtrain.common.core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @class BaseDTO
 * @classdesc 考虑DTO从这里继承便于统一DTO接口和转型判断
 *
 * @author Administrator
 * @date 2020-6-19  10:37
 * @version 1.0.0
 * @see
 * @since
 */
public abstract class BaseDTO implements Serializable {
    private static final long serialVersionUID = 455424324322L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 状态
     */
    private Integer status;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone = "GMT+8")
    private Date updatedTime;

    /**
     * 版本
     */
    private Long version;


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     *  更新人ID 后续的update更新此字典
     */
    private Long updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

}
