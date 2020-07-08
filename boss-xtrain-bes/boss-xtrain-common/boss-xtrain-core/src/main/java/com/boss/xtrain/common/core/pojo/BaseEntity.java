/**
 * @file:  BaseEntity.java
 * @author: Administrator    
 * @date:   2020-6-19 11:22
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved. 
 */  
package com.boss.xtrain.common.core.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @class BaseEntity
 * @classdesc 系统表包含的公用字段进行提取，统一切面也将使用该类型
 * @author ChenTong
 * @date 2020-6-19  10:39
 * @version 1.0
 * @see
 * @since
 */
public abstract class BaseEntity implements Serializable {
 
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * 状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 记录所属公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 组织机构ID ，一个组织机构包含多个公司
     */
    @Column(name = "org_id")
    private Long organizationId;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     *  创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     *  更新时间记录便于追踪
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     *  更新人ID 后续的update更新此字典
     */
    @Column(name = "updated_by")
    private Long updatedBy;

    /**
     *  当前行的版初始为0 每次数据变动则加1
     */
    @Column(name = "version")
    private Long version;

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public BaseEntity() {
    }
}
