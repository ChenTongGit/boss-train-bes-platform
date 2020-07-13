package com.boss.xtrain.paper.vo.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class TemplateListVO extends BaseVO {
    @NotBlank(message = "模板ID不能为空")
    private List<DeleteTemplateVO> deleteTemplateVos;

}
