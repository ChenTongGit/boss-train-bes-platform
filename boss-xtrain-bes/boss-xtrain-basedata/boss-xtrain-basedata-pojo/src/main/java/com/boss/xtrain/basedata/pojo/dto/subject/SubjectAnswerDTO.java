package com.boss.xtrain.basedata.pojo.dto.subject;

import lombok.Data;

@Data
public class SubjectAnswerDTO {
    private  Long id;
    private Long subjectId;
    private String answer;
    private Byte rightAnswer;

}
