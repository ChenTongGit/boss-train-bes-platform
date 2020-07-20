package com.boss.xtrain.basedata.pojo.vo.category;

import lombok.Data;

import java.util.List;

@Data
public class CategoryIdsVO {
    private Long orgId;
    private List<Long> ids;
}
