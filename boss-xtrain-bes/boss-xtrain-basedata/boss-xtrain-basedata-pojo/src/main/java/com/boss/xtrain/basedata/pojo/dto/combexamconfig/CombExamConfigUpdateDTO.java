package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CombExamConfigUpdateDTO extends BaseDTO {
    private Long id;
    private String name;
    private Long difficulty;
    private String remark;
    private List<CombExamItemDTO> itemList;
    private List<Long> deleteItemIds;

}
