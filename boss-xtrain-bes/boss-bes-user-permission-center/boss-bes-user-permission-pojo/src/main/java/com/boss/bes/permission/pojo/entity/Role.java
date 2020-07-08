package com.boss.bes.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;

import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_role")
public class Role extends BaseEntity {
    private List<User> users;
    private List<Resource> resources;
    private Long organizationId;
    private String name;
    private String code;
    private String remark;
}
