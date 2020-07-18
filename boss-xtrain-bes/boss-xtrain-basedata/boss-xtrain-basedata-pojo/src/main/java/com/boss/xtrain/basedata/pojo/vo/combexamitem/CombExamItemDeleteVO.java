package com.boss.xtrain.basedata.pojo.vo.combexamitem;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CombExamItemDeleteVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Long version;
}
