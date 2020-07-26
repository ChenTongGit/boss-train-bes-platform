package com.boss.xtrain.basedata.pojo.dto.category;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class CategoryIdsDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orgId;
    private List<Long> ids;
}
