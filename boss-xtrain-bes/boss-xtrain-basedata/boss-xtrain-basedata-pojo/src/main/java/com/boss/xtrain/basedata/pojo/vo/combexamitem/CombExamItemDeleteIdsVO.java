package com.boss.xtrain.basedata.pojo.vo.combexamitem;

import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.util.List;

@Data
public class CombExamItemDeleteIdsVO {
    private List<CombExamItemDeleteVO> combExamItems;
}
