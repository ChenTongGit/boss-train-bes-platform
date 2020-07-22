package com.boss.xtrain.paper.dto.papermanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**题目对象
 * @author lenovo
 */
@Data
public class SubjectDTO{
    /**
     * 试卷ID
     */
    private Long paperId;
    /**
     * 题目ID
     */
    private Long subjectId;
    /**
     * 题型
     */
    private Long categoryId;
    /**
     * 分数
     */
    private BigDecimal score;
    /**
     * 题目
     */
    private String subject;
    /**
     * 答案集合
     */
    private List<AnswerDTO> answers;
    /**
     * 题目难度
     */
    private Long difficult;
    /**
     * 题目类别
     */
    private Long typeId;
}

