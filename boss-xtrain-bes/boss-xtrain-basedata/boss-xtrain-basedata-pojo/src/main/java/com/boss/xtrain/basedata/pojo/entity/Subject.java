package com.boss.xtrain.basedata.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_subject")
public class Subject extends BaseEntity implements Serializable {

    /**
     * 题型ID
     */
    @Column(name = "t_s_id")
    private Long subjectTypeId;

    /**
     * 题目类别ID
     */
    @Column(name = "t_c_id")
    private Long categoryId;

    /**
     * 题目
     */
    @Column(name = "name")
    private String name;

    /**
     * 图片路径
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 保留字段1
     */
    @Column(name = "field1")
    private String field1;

    /**
     * 保留字段2
     */
    @Column(name = "field2")
    private String field2;

    /**
     * 保留字段3
     */
    @Column(name = "field3")
    private String field3;

    private static final long serialVersionUID = 1L;

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}