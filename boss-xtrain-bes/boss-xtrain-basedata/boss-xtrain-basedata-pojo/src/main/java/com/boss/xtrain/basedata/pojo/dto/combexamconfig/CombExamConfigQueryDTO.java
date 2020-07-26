package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CombExamConfigQueryDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orgId;
    private String name;
}

