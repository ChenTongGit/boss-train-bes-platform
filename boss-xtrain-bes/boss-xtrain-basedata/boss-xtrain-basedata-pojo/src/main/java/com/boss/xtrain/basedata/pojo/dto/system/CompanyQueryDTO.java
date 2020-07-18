package com.boss.xtrain.basedata.pojo.dto.system;

import lombok.Data;

import java.util.List;

@Data
public class CompanyQueryDTO {
    private Long orgId;
    private List<Long> companyIds;
}
