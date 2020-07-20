package com.boss.xtrain.paper.vo.papermanage;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**删除试卷对象
 * @author lenovo
 */
@Data
public class DeletePaperVO extends BaseVO {
    /**
     * 试卷ID
     */
    @NotBlank(message = "试卷ID不能为空")
    private String paperId;

}
