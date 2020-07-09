package com.boss.bes.paper.vo.papermanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**查询试卷题目对象
 * @author lenovo
 */
@Data
public class SubjectQueryVO extends BaseVO {
    /**
     * 试卷id
     */
    @NotBlank(message = "试卷ID不能为空")
    private String paperId;
}

