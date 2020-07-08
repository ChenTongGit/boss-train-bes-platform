package com.boss.xtrain.permission.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Data
@Table(name = "t_company")
public class Company extends BaseSystemEntity {
    @Transient
    private String orgName;

    /**
     * 组织机构ID ，一个组织机构包含多个公司
     */
    @Column(name = "t_o_id")
    private Long organizationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.name
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "name")
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.code
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "code")
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.mnemonic_code
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "mnemonic_code")
    private String mnemonicCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.master
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "master")
    private String master;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.tax
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "tax")
    private String tax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.fax
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "fax")
    private String fax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.tel
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "tel")
    private String tel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.address
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "address")
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.email
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "email")
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.website
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    @Column(name = "website")
    private String website;

    /**
     *  当前行的版初始为0 每次数据变动则加1
     */
    @Column(name = "version")
    private Long version;

}