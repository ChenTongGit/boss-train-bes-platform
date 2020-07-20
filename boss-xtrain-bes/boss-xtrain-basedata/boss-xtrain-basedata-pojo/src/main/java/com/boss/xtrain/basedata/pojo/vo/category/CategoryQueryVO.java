package com.boss.xtrain.basedata.pojo.vo.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryQueryVO{
    private String name;
    private Long orgId;

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    @JsonProperty(value = "name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "orgId")
    public Long getOrgId() {
        return orgId;
    }

    @JsonProperty(value = "orgId")
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
