package com.boss.bes.paper.vo.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

/**查询模板对象
 * @author lenovo
 */
@Data
public class TemplateQueryVO extends BaseQuery {
    /**
     * 组织机构ID
     */
    private String orgId;
    /**
     * 公司ID
     */
    private String companyId;

}
