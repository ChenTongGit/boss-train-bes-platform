package com.boss.xtrain.paper.vo.templatecomb;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/** 查询模板
 * @author lenovo
 */
@Data
public class TemplateQueryVO extends BaseQuery {
    /**
     * 组织id
     */
    @NotBlank(message = "组织机构ID不能为空")
    private String orgId;

}

