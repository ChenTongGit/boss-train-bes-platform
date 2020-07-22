package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemVO;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
    private List<CombExamItemDTO> combExamItems;
}
