package com.boss.xtrain.basedata.pojo.dto.subjecttype;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SubjectTypeDeleteDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
}
