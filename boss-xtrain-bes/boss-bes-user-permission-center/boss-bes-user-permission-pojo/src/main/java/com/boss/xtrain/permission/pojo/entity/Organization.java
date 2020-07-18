package com.boss.xtrain.permission.pojo.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Data
@Table(name = "t_organization")
public class Organization extends BaseSystemEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "master")
    private String master;

    @Column(name = "tel")
    private String tel;

    @Column(name = "address")
    private String address;

}