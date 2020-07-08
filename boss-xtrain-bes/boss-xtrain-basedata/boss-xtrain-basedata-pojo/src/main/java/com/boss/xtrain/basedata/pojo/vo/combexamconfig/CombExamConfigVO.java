package com.boss.xtrain.basedata.pojo.vo.combexamconfig;

import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CombExamConfigVO extends BaseVO {
    private Long id;
    private String name;
    private Date updateTime;
    private String updateBy;
    private Long version;
    private List<CombExamItem> combExamItems;
}
