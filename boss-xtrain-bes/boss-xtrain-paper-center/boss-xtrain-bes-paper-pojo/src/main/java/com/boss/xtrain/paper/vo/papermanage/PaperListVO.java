package com.boss.xtrain.paper.vo.papermanage;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**批量删除试卷集合对象
 * @author lenovo
 */
@Data
public class PaperListVO extends BaseVO {
    @NotBlank(message = "试卷ID不能为空")
    private List<DeletePaperVO> deletePaperVos;

}

