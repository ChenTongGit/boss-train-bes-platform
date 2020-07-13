package com.boss.xtrain.paper.dto.baseinfo;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**查询公司名对象
 * @author lenovo
 */
@Data
public class CompanyInfoDTO extends BaseDTO {
    /**
     * 公司名
     */
    private String companyName;
}

