package com.boss.xtrain.paper.dto.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 查询组卷配置对象
 * @author lenovo
 */
@Data
public class CombConfigQueryDTO extends BaseQuery {
    /**
     * 组织机构ID
     */
    private Long orgId;
    protected int pageNum;
    protected int pageSize;

}

