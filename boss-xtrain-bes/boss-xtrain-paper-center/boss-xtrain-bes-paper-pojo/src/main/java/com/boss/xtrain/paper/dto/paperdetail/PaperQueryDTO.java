package com.boss.xtrain.paper.dto.paperdetail;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

/**试卷查询对象
 * @author lenovo
 */
@Data
public class PaperQueryDTO extends BaseQuery {
    /**
     * 公司IDs
     */
    private Long  companyId;
    /**
     * 公司IDs
     */
    private Long  orgId;
    protected int pageNum;
    protected int pageSize;
}

