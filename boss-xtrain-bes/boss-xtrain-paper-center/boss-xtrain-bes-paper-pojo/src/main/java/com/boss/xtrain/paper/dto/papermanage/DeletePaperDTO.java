package com.boss.xtrain.paper.dto.papermanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;
/**
 * @version: V1.0
 * @className: DeletePaperDTO
 * @packageName: com.boss.bes.paper.pojo.dto.papermanage
 * @description: 删除试卷对象
 * @data: 23:58 2019/12/14
 **/

@Data
public class DeletePaperDTO extends BaseDTO {
    /**
     * 试卷ID
     */
    private Long paperId;

}

