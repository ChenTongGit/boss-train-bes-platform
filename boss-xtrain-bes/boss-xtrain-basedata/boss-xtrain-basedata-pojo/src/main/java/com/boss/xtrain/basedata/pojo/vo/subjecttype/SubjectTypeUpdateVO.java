package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

@Data
public class SubjectTypeUpdateVO extends BaseVO {
    private Long id;
    private String name;
    private String attribute;
    private Long version;
}
