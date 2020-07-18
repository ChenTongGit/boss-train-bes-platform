package com.boss.xtrain.paper.dto.uploadexam;

import lombok.Data;

/**试卷查询对象
 * @author lenovo
 */
@Data
public class PaperQueryDTO{
    /**
     * 公司IDs
     */
    private Long  companyId;
    /**
     * 组织机构IDs
     */
    private Long  orgId;
}
