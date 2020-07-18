package com.boss.xtrain.paper.dto.papermanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**查询试题对象
 * @author lenovo
 */
@Data
public class SubjectQueryDTO extends BaseDTO {
    /**
     * 试卷id
     */
    private Long paperId;
}

