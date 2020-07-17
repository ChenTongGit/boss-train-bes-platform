package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SubjectTypeDeleteVO{
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Long version;
}
