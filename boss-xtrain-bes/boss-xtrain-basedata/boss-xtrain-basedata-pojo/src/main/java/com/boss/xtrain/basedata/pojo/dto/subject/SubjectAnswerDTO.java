package com.boss.xtrain.basedata.pojo.dto.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SubjectAnswerDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private  Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectId;
    private String answer;
    private Integer rightAnswer;
    private String difficulty;
    private String subjectName;
    private String subjectTypeName;
    private String categoryName;

}
