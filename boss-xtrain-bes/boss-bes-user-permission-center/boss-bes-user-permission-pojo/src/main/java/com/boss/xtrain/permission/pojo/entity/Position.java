package com.boss.xtrain.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;

import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "position")
@EqualsAndHashCode(callSuper = false)
public class Position extends BaseEntity {
    private Long userId;
    private String name;
    private String code;
    private String remark;
    private String companyName;
}
