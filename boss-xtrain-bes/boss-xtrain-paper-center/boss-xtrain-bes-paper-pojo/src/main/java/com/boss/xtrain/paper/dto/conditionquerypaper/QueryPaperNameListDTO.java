package com.boss.xtrain.paper.dto.conditionquerypaper;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**试卷还是模板的标识
 * @author lenovo
 */
@Data
public class QueryPaperNameListDTO extends BaseDTO {
    /**
     * 试卷模板标识
     */
    private Boolean template;

}

