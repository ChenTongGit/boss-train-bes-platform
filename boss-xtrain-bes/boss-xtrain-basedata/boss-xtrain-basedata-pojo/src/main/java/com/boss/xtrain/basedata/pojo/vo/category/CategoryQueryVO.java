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
    private int pageIndex;
    private int pageSize;
    private String orderBy;

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

    @JsonProperty(value = "pageIndex")
    public int getPageIndex() {
        return pageIndex;
    }

    @JsonProperty(value = "pageIndex")
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @JsonProperty(value = "pageSize")
    public int getPageSize() {
        return pageSize;
    }

    @JsonProperty(value = "pageSize")
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty(value = "orderBy")
    public String getOrderBy() {
        return orderBy;
    }

    @JsonProperty(value = "orderBy")
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
