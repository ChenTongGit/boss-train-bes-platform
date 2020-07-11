package com.boss.xtrain.basedata.pojo.vo.category;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

@Data
public class CategoryQueryVO extends BaseQuery {
    private String name;
    private Long orgId;
}
