package com.boss.xtrain.basedata.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Table(name = "t_subject_type")
@Data
public class SubjectType extends BaseEntity implements Serializable {
    /**
     * 题型名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 属性列
     */
    @Column(name = "attribute")
    private String attribute;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

}