package com.boss.xtrain.basedata.pojo.vo.category;

import com.boss.xtrain.common.core.pojo.TreeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.List;

@Data
public class CategoryTreeVO extends TreeEntity {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String remark;
    private Long value;
    private String label;
    private List<CategoryTreeVO> children;

}
