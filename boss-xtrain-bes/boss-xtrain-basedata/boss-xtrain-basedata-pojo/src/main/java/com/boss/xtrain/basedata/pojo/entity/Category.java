package com.boss.xtrain.basedata.pojo.entity;

import java.io.Serializable;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_category")
public class Category extends BaseEntity implements Serializable {

    /**
     * 类别名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 父类别ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;


    private static final long serialVersionUID = 1L;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", remark='" + remark + '\'' +
                '}';
    }


}