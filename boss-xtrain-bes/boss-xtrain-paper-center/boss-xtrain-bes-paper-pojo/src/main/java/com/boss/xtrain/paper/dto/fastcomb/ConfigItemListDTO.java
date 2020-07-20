package com.boss.xtrain.paper.dto.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 组卷配置明细集合对象
 * @author lenovo
 */
@Data
public class ConfigItemListDTO extends BaseDTO {
    @NotBlank(message = "组卷配置明细不能为空")
    private List<ConfigItemDTO> itemList;
}
