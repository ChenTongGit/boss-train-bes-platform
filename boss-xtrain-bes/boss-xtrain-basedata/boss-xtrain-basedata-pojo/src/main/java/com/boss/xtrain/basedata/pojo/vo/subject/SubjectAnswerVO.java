package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SubjectAnswerVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Integer rightAnswer;
    private String answer;
    private String imageUrl;
    private Long subjectId;
    private String difficulty;
    private String subjectName;
    private String subjectTypeName;

}
