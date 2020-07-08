package com.boss.xtrain.basedata.pojo.vo.category;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

@Data
public class CategoryInsertVO extends BaseVO {
    private String name;
    private Long parentId;
}
