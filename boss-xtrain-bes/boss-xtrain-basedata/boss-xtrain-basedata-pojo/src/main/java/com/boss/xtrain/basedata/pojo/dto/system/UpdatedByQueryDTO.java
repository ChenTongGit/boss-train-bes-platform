package com.boss.xtrain.basedata.pojo.dto.system;

import lombok.Data;

import java.util.List;

@Data
public class UpdatedByQueryDTO {
    private Long orgId;
    private List<Long> userIds;
}
