package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class CombExamConfigDTO extends BaseEntity {
    private Long id;
    private String name;
    private String remark;
}
