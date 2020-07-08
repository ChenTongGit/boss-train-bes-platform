package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectAnswerVO extends BaseVO {
    private Long id;
    private String name;
    private String rightAnswer;
    private String imageUrl;
    private Long subjectId;
    private String field1;
    private String field2;
    private String field3;
}
