package com.boss.xtrain.basedata.pojo.dto.category;

import lombok.Data;

import java.util.List;

@Data
public class CategoryIdsDTO {
    private Long orgId;
    private List<Long> ids;
}
