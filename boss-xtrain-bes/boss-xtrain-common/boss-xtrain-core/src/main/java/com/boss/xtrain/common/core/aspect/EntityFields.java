package com.boss.xtrain.common.core.aspect;

import java.io.Serializable;
import java.util.Date;

/**
 * entity共有属性实体类，存放共有属性实体类
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/4 17:04
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class EntityFields implements Serializable {
    public static final long serialVersionUID = 4553214324322L;
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
    private Date createdTime;
    /**
     *  创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    private Long createdBy;
    /**
     *  更新时间记录便于追踪
     */
    private Date updatedTime;
    /**
     *  更新人ID 后续的update更新此字典
     */
    private Long updatedBy;


    public EntityFields(Long companyId, Long organizationId, Date createdTime, Long createdBy, Date updatedTime, Long updatedBy) {
        this.companyId = companyId;
        this.organizationId = organizationId;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.updatedTime = updatedTime;
        this.updatedBy = updatedBy;
    }

    public EntityFields() {
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
