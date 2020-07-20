package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CombExamConfigDeleteDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Long version;
}

