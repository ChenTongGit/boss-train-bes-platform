package com.boss.xtrain.basedata.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_comb_exam_config")
public class CombExamConfig extends BaseEntity implements Serializable {
    /**
     * 组卷配置ID
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 配置名
     */
    @Column(name = "name")
    private String name;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;


    private static final long serialVersionUID = 1L;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Override
    public String toString() {
        return "CombExamConfig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}