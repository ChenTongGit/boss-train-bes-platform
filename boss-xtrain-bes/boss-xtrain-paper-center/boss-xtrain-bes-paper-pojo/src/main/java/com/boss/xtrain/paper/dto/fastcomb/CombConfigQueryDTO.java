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
    @NotBlank(message = "组织机构ID不能为空")
    private Long orgId;
    protected int pageNum;
    protected int pageSize;

}

