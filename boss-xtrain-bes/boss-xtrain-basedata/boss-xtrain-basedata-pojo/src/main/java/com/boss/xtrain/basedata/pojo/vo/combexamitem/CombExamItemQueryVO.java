package com.boss.xtrain.basedata.pojo.vo.combexamitem;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CombExamItemQueryVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Long orgId;
    private String name;
}
