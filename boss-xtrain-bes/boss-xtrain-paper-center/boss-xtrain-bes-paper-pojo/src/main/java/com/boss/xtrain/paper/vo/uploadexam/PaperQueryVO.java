package com.boss.xtrain.paper.vo.uploadexam;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

/**试卷查询对象
 * @author lenovo
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

