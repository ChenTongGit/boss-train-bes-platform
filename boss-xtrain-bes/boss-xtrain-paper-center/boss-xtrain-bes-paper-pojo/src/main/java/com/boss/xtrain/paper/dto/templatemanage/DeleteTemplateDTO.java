package com.boss.xtrain.paper.dto.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**删除模板对象
 * @author lenovo
 */
@Data
public class DeleteTemplateDTO extends BaseDTO {
    /**
     * 模板id
     */
    private Long paperId;

}

