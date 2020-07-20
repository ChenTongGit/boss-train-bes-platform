package com.boss.xtrain.basedata.pojo.vo.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SubjectAnswerQueryVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectId;
}
