package com.boss.xtrain.basedata.pojo.dto.paper;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreatePaperDTO extends BaseDTO {
    @NotBlank(message = "组卷配置ID不能为空")
    private Long id;
}

