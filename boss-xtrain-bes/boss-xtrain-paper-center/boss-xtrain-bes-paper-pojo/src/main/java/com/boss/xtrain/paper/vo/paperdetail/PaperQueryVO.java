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
    @NotBlank(message = "组织机构ID不能为空")
    private String orgId;

}

