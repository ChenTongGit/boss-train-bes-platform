package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectQuery extends BaseQuery {
    private String name;
    private String categoryName;
    private String subjectTypeName;
    private String subjectName;

}
