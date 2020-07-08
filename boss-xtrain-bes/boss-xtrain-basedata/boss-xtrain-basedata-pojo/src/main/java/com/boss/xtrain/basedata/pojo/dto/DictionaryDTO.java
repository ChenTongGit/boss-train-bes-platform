package com.boss.xtrain.basedata.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionaryDTO extends BaseEntity {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String category;
    private String value;
    private String remark;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark(){
        return this.remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "DictionaryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
