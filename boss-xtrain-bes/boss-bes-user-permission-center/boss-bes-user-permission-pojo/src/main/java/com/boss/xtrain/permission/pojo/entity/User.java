package com.boss.xtrain.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_user")
public class User extends BaseSystemEntity {
    private List<Role> roles;
    @Column(name = "t_d_id")
    private Long departmentId;
    @Column(name = "t_c_id")
    private Long companyId;
    @Column(name = "code")
    private String code;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private int sex;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "tel")
    private String tel;
    @Column(name = "email")
    private String email;
    @Column(name = "other")
    private String other;

}
