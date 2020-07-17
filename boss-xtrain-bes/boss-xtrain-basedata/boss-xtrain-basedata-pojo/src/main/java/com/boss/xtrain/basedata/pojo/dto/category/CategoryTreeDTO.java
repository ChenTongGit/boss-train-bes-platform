package com.boss.xtrain.basedata.pojo.dto.category;

import com.boss.xtrain.basedata.pojo.vo.category.CategoryTreeVO;
import com.boss.xtrain.common.core.pojo.TreeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data
public class CategoryTreeDTO extends TreeEntity {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String remark;
    private Long value;
    private List<CategoryTreeDTO> children;
}
