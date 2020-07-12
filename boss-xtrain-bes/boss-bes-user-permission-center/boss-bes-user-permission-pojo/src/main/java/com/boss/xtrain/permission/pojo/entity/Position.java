package com.boss.xtrain.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "position")
@EqualsAndHashCode(callSuper = false)
public class Position extends BaseSystemEntity {

    @Column(name = "t_u_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "t_c_id")
    private String companyId;
}
