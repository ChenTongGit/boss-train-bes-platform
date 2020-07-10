package com.boss.xtrain.permission.pojo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Data
@Table(name = "t_department")
@EqualsAndHashCode(callSuper = false)
public class Department extends BaseSystemEntity {

    @Column(name = "t_c_id")
    private Long companyId;

    @Transient
    private String companyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.name
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "name")
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.mnemonic_code
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "mnemonic_code")
    private String mnemonicCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.code
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "code")
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.level
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "level")
    private String level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.parent_id
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.master
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "master")
    private String master;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.descript
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "descript")
    private String description;

    /**
     *  当前行的版初始为0 每次数据变动则加1
     */
    @Column(name = "version")
    private Long version;
}