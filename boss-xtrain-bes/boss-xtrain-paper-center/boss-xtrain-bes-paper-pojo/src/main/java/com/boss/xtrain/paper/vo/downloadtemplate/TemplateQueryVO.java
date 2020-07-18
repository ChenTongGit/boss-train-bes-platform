package com.boss.xtrain.paper.vo.downloadtemplate;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

/**模板查询对象
 * @author lenovo
 */
@Data
public class TemplateQueryVO extends BaseQuery {
    /**
     * 组织id
     */
    private String orgId;
    /**
     * 公司id
     */
    private String companyId;

}

