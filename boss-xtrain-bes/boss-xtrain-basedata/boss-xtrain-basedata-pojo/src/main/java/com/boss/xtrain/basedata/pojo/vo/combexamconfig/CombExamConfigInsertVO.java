package com.boss.xtrain.basedata.pojo.vo.combexamconfig;

import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.util.List;

@Data
public class CombExamConfigInsertVO extends BaseVO {
    private String name;
    private Long difficult;
    private List<CombExamItem> combExamItems;
}
