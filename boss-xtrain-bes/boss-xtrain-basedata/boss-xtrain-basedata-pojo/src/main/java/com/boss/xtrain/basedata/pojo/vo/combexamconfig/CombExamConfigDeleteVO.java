package com.boss.xtrain.basedata.pojo.vo.combexamconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CombExamConfigDeleteVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Long version;
}
