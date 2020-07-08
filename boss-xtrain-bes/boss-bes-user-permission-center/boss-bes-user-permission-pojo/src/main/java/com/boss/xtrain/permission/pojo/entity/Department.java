package com.boss.xtrain.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Data
@Table(name = "t_department")
public class Department extends BaseEntity {

    @Transient
    private String companyName;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.name
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.mnemonic_code
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String mnemonicCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.code
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.level
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.parent_id
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private Long parentId;

    @Transient
    private String parentName;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.master
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String master;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.descript
     *
     * @mbg.generated Mon Jul 06 12:22:48 CST 2020
     */
    private String description;

}