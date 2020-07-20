package com.boss.xtrain.basedata.api.paper;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

@Data
public class SubjectTypePaperVO extends BaseVO {
    private String subjectId;
    private String typeName;
    private String attribute;
}
