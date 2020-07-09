package com.boss.bes.paper.dto.downloadtemplate;

import lombok.Data;

/**模板查询对象
 * @author lenovo
 */
@Data
public class TemplateQueryDTO{
    /**
     * 组织id
     */
    private Long orgId;
    /**
     * 公司id
     */
    private Long companyId;

}
