package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectQuery extends BaseVO {
    private String name;
    private Long subjectTypeId;
    private Long categoryId;
}
