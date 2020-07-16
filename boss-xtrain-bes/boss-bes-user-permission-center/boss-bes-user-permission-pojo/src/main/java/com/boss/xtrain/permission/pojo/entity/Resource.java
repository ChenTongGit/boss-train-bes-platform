package com.boss.xtrain.permission.pojo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_resource")
public class Resource extends BaseSystemEntity {
    @Column(name = "tenant_name")
    private  Long tenantName;
    @Column(name = "code")
    private String code;
    @Column(name = "order_index")
    private int orderIndex;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "url")
    private String url;
    @Column(name = "open_img")
    private String openImg;
    @Column(name = "close_img")
    private String closeImg;
    @Column(name = "resource_type")
    private String resourceType;
    @Column(name = "leaf")
    private int leaf;
    @Column(name = "action")
    private String action;
    @Column(name = "remark")
    private String remark;
}
