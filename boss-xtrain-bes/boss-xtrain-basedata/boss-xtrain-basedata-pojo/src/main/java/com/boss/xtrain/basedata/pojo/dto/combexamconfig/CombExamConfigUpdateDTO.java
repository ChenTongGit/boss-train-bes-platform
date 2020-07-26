package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class CombExamConfigUpdateDTO extends BaseDTO implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Long difficulty;
    private String difficultyName;
    private String remark;
    private transient List<CombExamItemDTO> itemList;
    private List<Long> deleteItemIds;

}
