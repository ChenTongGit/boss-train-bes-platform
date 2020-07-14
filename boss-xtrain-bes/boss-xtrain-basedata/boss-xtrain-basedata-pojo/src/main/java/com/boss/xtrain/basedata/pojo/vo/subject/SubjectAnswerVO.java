package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SubjectAnswerVO {
    private Long id;
    private String rightAnswer;
    private String answer;
    private String imageUrl;
    private Long subjectId;
    private String field1;
    private String field2;
    private String field3;
}
