package com.boss.xtrain.paper.dto.papermanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.*;

/**
 * @version: V1.0
 * @className: ExamAnswerDTO
 * @packageName: com.boss.bes.paper.pojo.dto.papermanage
 * @description: 答案对象
 * @data: 11:00 2020/1/6
 **/
@Data
public class AnswerDTO extends BaseDTO {
    /**
     * 题目ID
     */
    private Long subjectId;
    /**
     * 答案ID
     */
    private Long paperSubjectAnswerId;
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
