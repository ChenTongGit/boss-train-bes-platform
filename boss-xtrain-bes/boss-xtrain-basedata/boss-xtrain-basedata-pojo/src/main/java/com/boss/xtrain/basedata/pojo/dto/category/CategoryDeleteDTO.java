package com.boss.xtrain.basedata.pojo.dto.category;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDeleteDTO{
    private Long id;
    private String name;
    private Long version;
}
