package com.boss.xtrain.basedata.pojo.dto.category;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CategoryDeleteDTO{
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Long version;
}
