package com.boss.bes.paper.vo.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SubjectQueryVO extends BaseVO {
    /**
     * 试卷id
     */
    @NotBlank(message = "试卷ID不能为空")
    private String paperId;
}
