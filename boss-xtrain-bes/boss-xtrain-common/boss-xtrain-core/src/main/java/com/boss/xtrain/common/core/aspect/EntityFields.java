package com.boss.xtrain.common.core.aspect;

import java.io.Serializable;

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
     *  创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    private Long createdBy;

    /**
     *  更新人ID 后续的update更新此字典
     */
    private Long updatedBy;

    public EntityFields(Long companyId, Long orgId, Long createdBy, Long updatedBy) {
        this.companyId = companyId;
        this.organizationId = orgId;
        this.createdBy = createdBy;
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

    public Long getOrgId() {
        return organizationId;
    }

    public void setOrgId(Long orgId) {
        this.organizationId = orgId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }


    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "EntityFields{" +
                "companyId=" + companyId +
                ", orgId=" + organizationId +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
