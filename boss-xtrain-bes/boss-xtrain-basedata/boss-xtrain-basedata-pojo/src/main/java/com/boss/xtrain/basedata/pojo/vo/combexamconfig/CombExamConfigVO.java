package com.boss.xtrain.basedata.pojo.vo.combexamconfig;

import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemVO;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
public class CombExamConfigVO extends BaseVO {
    private Long id;
    @NotBlank(message = "组卷配置名称不为空")
    private String name;
    private String difficultName;
    private Long difficult;
    private String remark;
    private String companyName;
    private String updateByName;
    private List<CombExamItemVO> combExamItems;
}
