package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data
public class CombExamConfigUpdateDTO extends BaseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Long difficulty;
    private String difficultyName;
    private String remark;
    private List<CombExamItemDTO> itemList;
    private List<Long> deleteItemIds;

}
