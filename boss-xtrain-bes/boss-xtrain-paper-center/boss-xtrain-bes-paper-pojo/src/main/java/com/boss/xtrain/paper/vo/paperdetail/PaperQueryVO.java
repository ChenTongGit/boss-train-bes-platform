package com.boss.xtrain.paper.vo.paperdetail;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**查询试卷对象
 * @author lenovo
 */
@Data
public class PaperQueryVO extends BaseQuery {
    /**
     * 公司ID
     */
    private String companyId;
    /**
     * 组织ID
     */
    private String orgId;
    protected int pageNum;
    protected int pageSize;
}

