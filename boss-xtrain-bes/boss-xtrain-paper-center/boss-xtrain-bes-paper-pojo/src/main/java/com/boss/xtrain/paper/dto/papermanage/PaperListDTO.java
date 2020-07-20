package com.boss.xtrain.paper.dto.papermanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.util.List;

/**删除模板集合对象
 * @author lenovo
 */
@Data
public class PaperListDTO extends BaseDTO {
    private List<DeletePaperDTO> deletePaperVos;

}

