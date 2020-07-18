package com.boss.xtrain.basedata.pojo.vo.combexamconfig;

import lombok.Data;

@Data
public class CombExamConfigQueryVO{
    private Long orgId;
    private String name;
    private int pageIndex;
    private int pageSize;
}
