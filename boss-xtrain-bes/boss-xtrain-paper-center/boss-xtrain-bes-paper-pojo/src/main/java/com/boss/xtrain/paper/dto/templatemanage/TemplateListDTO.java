package com.boss.xtrain.paper.dto.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.util.List;

/**删除模板集合对象
 * @author lenovo
 */
@Data
public class TemplateListDTO extends BaseDTO {
    private List<DeleteTemplateDTO> deleteTemplateVos;

}

