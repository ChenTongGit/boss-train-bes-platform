package com.boss.bes.paper.dto.baseinfo;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**查询试卷基础信息对象
 * @author lenovo
 */
@Data
public class PaperInfoDTO extends BaseDTO {
    private String value;
    private String dictionaryName;
}

