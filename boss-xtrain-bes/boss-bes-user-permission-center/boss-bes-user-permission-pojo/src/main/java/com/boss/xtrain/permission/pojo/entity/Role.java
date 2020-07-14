package com.boss.xtrain.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_role")
public class Role extends BaseSystemEntity {
    private List<User> users;
    private List<Resource> resources;
    @Column(name = "t_o_id")
    private Long organizationId;
    @Column(name = "t_c_id")
    private Long companyId;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "remark")
    private String remark;
}
