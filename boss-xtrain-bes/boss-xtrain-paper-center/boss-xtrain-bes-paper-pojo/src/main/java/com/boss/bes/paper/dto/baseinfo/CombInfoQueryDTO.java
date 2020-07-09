package com.boss.bes.paper.dto.baseinfo;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**查询基础信息对象
 * @author lenovo
 */
@Data
public class CombInfoQueryDTO extends BaseDTO {
    /**
     * Description: 字段名
     */
    @NotBlank(message = "字段名不能为空")
    private String category;
}

