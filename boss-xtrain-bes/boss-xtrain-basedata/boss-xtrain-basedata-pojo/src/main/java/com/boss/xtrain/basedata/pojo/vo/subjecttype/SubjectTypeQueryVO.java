package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

@Data
public class SubjectTypeQueryVO extends BaseQuery {
    private Long orgId;
    private String name;
    private int pageIndex;
    private int pageSize;
    private String orderBy;
}
