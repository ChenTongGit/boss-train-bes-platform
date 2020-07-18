package com.boss.xtrain.paper.dto.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**
 * 题目查询对象
 */
@Data
public class SubjectQueryDTO extends BaseDTO {
    /**
     * 试卷id
     */
    private Long paperId;

}

