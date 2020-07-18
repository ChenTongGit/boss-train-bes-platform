package com.boss.xtrain.paper.vo.fastcomb;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;

/**
 * 答案对象
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

