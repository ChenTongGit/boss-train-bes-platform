package com.boss.xtrain.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;

import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_resource")
public class Resource extends BaseEntity {
    private Long moduleDetailId;
    private  Long tenantName;
    private String code;
    private int orderIndex;
    private Long parentId;
    private String url;
    private String openImg;
    private String closeImg;
    private String resourceType;
    private int leaf;
    private String action;
    private String remark;
}
