package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectInsertVO extends BaseVO {
    private String name;
    private Long subjectTypeId;
    private Long categoryId;
    private Long difficult;
    private List<SubjectAnswer> subjectAnswers;

}
