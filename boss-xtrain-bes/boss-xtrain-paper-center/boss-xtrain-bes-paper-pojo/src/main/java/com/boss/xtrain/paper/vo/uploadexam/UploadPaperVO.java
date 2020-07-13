package com.boss.xtrain.paper.vo.uploadexam;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**上传试卷对象
 * @author lenovo
 */
@Data
public class UploadPaperVO extends BaseVO {
    /**
     * 试卷id
     */
    @NotBlank(message = "试卷ID不能为空")
    private String paperId;
    /**
     * 试卷描述
     */
    @Length(max = 128,message = "模板描述不能超过128个字符")
    private String discript;
    /**
     * 模板名
     */
    @NotBlank(message = "模板名不能为空")
    @Length(max = 32,message = "模板名不能超过32个字符")
    private String paperName;
    /**
     * 试卷类型
     */
    @NotBlank(message = "试卷类型不能为空")
    private String paperType;
    /**
     * 试卷难度
     */
    @NotBlank(message = "试卷难度不能为空")
    private String difficulty;
}

