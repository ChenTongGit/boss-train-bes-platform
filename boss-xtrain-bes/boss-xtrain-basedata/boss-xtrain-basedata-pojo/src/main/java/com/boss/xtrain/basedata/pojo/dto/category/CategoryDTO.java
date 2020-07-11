package com.boss.xtrain.basedata.pojo.dto.category;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CategoryDTO extends BaseEntity {
    private String name;
    private Long parentId;
    private String remark;
}
