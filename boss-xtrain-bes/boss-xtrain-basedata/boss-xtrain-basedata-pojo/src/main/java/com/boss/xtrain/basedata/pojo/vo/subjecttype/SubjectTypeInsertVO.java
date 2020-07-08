package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

@Data
public class SubjectTypeInsertVO extends BaseVO {
    private String name;
    private String attribute;
}
