package com.boss.xtrain.basedata.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Table;


/**
 * @author gxr
 * @description 数据字典
 * @date 2020/7/1
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "t_dictionary")
@Data
public class Dictionary extends BaseEntity{
    private Long id;
    /**
     * 字典名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 字典类型
     */
    @Column(name = "category")
    private String category;

    /**
     * 参数值
     */
    @Column(name = "value")
    private String value;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
}