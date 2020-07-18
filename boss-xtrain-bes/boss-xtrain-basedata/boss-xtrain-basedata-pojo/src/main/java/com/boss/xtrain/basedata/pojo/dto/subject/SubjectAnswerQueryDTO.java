package com.boss.xtrain.basedata.pojo.dto.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SubjectAnswerQueryDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectId;
}
