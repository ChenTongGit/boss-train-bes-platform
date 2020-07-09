package com.boss.bes.paper.vo.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**删除模板对象
 * @author lenovo
 */
@Data
public class DeleteTemplateVO extends BaseVO {
    /**
     * 模板id
     */
    @NotBlank(message = "模板ID不能为空")
    private String paperId;

}

