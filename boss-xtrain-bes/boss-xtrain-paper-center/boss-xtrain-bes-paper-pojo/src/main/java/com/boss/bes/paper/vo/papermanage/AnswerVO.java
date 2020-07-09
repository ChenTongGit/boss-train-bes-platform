package com.boss.bes.paper.vo.papermanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**答案对象
 * @author lenovo
 */
@Data
public class AnswerVO extends BaseVO {
    /**
     * 题目ID
     */
    private String subjectId;
    /**
     * 答案ID
     */
    private String answerId;
    /**
     * 答案
     */
    @NotBlank(message = "答案不能为空")
    @Size(max = 128,message = "答案不能超过128个字符")
    private String answer;
    /**
     * 是否是正确答案
     */
    @NotBlank(message = "答案选项不能为空")
    private Boolean rightAnswer;
    /**
     * 图片答案URL
     */
    private String url;

}

