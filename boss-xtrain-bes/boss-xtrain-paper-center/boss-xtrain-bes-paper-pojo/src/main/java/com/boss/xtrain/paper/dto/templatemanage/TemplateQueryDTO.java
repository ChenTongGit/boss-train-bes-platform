package com.boss.xtrain.paper.dto.templatemanage;

import lombok.Data;

/**模板查询对象
 * @author lenovo
 */
@Data
public class TemplateQueryDTO{
    /**
     * 组织机构ID
     */
    private Long orgId;
    /**
     * 公司ID
     */
    private Long companyId;
}
