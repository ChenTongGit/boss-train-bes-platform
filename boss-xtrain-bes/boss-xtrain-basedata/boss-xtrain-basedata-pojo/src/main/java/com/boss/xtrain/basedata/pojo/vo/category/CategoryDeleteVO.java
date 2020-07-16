package com.boss.xtrain.basedata.pojo.vo.category;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

@Data
public class CategoryDeleteVO extends BaseVO {
    private Long id;
    private String name;
    private Long version;
}
