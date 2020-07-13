package com.boss.xtrain.paper.dto.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

/**答案对象
 * @author lenovo
 */
@Data
public class AnswerDTO extends BaseDTO {
    /**
     * 题目ID
     */
    private Long subjectId;
    /**
     * 答案ID
     */
    private Long answerId;
    /**
     * 答案
     */
    private String answer;
    /**
     * 是否是正确答案
     */
    private Boolean rightAnswer;
    /**
     * 图片答案URL
     */
    private String url;
}

