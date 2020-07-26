package com.boss.xtrain.basedata.pojo.vo.combexamconfig;

import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemVO;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CombExamConfigVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @NotBlank(message = "组卷配置名称不为空")
    private String name;
    private String difficultyName = "";
    private Long difficulty;
    private String remark;
    private String companyName;
    private String updateByName;
    private List<CombExamItemVO> itemList;
}
