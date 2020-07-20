package com.boss.xtrain.paper.dto.papermanage;

import lombok.Data;

/**试卷查询对象
 * @author lenovo
 */
@Data
public class PaperQueryDTO{
    /**
     * 公司id
     */
    private Long companyId;
    /**
     * 组织机构id
     */
    private Long orgId;

}
