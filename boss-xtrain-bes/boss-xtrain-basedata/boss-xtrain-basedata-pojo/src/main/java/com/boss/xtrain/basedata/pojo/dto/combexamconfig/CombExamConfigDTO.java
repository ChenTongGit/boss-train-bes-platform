package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class CombExamConfigDTO extends BaseEntity {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String remark;
    private Long difficulty;
    private String difficultyName = "";
    private String companyName;
    private String updatedByName;
    private transient List<CombExamItemDTO> combExamItems;
}
