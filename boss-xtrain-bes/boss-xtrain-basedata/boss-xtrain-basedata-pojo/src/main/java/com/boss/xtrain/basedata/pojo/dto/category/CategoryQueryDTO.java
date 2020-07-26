package com.boss.xtrain.basedata.pojo.dto.category;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CategoryQueryDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orgId;
    private String name;
}
