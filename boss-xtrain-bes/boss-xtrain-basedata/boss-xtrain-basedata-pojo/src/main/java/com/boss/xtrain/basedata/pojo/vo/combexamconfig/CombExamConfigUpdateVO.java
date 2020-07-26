package com.boss.xtrain.basedata.pojo.vo.combexamconfig;

import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemVO;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CombExamConfigUpdateVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @NotBlank(message = "组卷配置名称不为空")
    private String name;
    private Long difficulty;
    private String difficultyName;
    private String remark;
    private List<CombExamItemVO> itemList;
}
