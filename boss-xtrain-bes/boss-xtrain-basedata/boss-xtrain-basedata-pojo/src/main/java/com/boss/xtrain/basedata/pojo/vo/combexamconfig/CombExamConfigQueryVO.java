package com.boss.xtrain.basedata.pojo.vo.combexamconfig;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

@Data
public class CombExamConfigQueryVO{
    private Long orgId;
    private String name;
    private int pageIndex;
    private int pageSize;
    private String orderBy;
}
