package com.boss.xtrain.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Data
@Table(name = "t_company")
public class Company extends BaseEntity {
    @Transient
    private String orgName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.name
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.code
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.mnemonic_code
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String mnemonicCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.master
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String master;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.tax
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String tax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.fax
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String fax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.tel
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String tel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.address
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.email
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_company.website
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String website;

}