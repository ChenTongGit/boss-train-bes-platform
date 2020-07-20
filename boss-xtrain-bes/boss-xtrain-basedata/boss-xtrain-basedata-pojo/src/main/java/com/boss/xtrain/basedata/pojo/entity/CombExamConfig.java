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

    @Column(name = "name")
    private String name;

    @Column(name = "remark")
    private String remark;


    private static final long serialVersionUID = 1L;

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
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}