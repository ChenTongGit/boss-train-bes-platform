package com.boss.xtrain.basedata.api.paper;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ConfigItemListDTO extends BaseDTO {
    private List<ConfigItemDTO> itemList;
}
