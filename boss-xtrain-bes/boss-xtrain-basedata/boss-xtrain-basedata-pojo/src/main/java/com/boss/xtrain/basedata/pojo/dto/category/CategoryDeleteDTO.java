package com.boss.xtrain.basedata.pojo.dto.category;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDeleteDTO{
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Long version;
}
