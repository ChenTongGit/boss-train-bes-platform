package com.boss.xtrain.paper.vo.conditionquerypaper;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**条件查询（标识查询模板还是查询试卷）
 * @author lenovo
 */
@Data
public class QueryPaperNameListVO extends BaseVO {
    /**
     * 试卷模板标识
     */
    @NotBlank(message = "模板标记不能为空")
    private Boolean template;
}

