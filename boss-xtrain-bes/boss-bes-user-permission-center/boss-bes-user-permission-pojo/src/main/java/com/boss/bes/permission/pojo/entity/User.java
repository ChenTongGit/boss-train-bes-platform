package com.boss.bes.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_user")
public class User extends BaseEntity {
    private List<Role> roles;
    private long departmentId;
    private String code;
    private String password;
    private String name;
    private int sex;
    private Date birthday;
    private String tel;
    private String email;
    private String other;
    private String remark;

}
