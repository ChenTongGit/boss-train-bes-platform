package com.boss.xtrain.paper.dto.uploadexam;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**上传试卷对象
 * @author lenovo
 */
@Data
public class UploadPaperDTO extends BaseDTO {
    /**
     * 试卷id
     */
    private Long paperId;
    /**
     * 试卷描述
     */
    private String discript;
    /**
     * 模板名
     */
    private String paperName;
    /**
     * 试卷类型
     */
    private Long paperType;
    /**
     * 试卷难度
     */
    private Long difficulty;
}

