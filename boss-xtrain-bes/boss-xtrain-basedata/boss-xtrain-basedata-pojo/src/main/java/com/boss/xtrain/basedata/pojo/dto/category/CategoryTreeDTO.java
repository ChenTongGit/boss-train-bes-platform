package com.boss.xtrain.basedata.pojo.dto.category;

import com.boss.xtrain.basedata.pojo.vo.category.CategoryTreeVO;
import com.boss.xtrain.common.core.pojo.TreeEntity;
import lombok.Data;

import java.util.List;

@Data
public class CategoryTreeDTO extends TreeEntity {
    private String name;
    private String remark;
    private Long value;
    private List<CategoryTreeDTO> children;
}
