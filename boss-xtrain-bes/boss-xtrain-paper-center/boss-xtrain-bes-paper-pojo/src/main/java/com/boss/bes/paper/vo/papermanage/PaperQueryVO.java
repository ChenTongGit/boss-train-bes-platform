package com.boss.bes.paper.vo.papermanage;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

/**
 * 试卷查询对象
 */
@Data
public class PaperQueryVO extends BaseQuery {
    /**
     * 公司id
     */
    private String companyId;
    /**
     * 组织机构id
     */
    private String orgId;
}
