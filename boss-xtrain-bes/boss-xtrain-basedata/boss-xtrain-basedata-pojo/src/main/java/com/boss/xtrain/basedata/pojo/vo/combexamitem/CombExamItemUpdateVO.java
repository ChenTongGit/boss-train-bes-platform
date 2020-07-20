package com.boss.xtrain.basedata.pojo.vo.combexamitem;

import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CombExamItemUpdateVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Date updateTime;
    private String updateBy;
    private Long version;
    private List<CombExamItem> combExamItems;
}
