package com.boss.bes.paper.vo.fastcomb;

import com.boss.xtrain.common.core.pojo.BaseVO;
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
    private Byte rightAnswer;
    /**
     * 图片答案URL
     */
    private String url;

}

