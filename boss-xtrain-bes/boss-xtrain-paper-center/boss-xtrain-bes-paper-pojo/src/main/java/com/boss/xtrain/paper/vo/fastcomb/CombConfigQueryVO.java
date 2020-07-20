package com.boss.xtrain.paper.vo.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

/**查询组卷项集合对象
 * @author lenovo
 */
@Data
public class CombConfigQueryVO extends BaseQuery {
    /**
     * 组织机构ID
     */
    private String orgId;

}

