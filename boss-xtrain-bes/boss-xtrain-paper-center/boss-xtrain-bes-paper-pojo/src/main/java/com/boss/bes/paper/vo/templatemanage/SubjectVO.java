package com.boss.bes.paper.vo.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**题目对象
 * @author lenovo
 */
@Data
public class SubjectVO extends BaseVO {
    /**
     * 试卷ID
     */
    private String paperId;
    /**
     * 题目ID
     */
    private String subjectId;
    /**
     * 题型
     */
    @NotBlank(message = "题型不能为空")
    private String categoryId;
    /**
     * 分数
     */
    @NotBlank(message = "题目分数不能为空")
    private BigDecimal score;
    /**
     * 题目
     */
    @NotBlank(message = "题目内容不能为空")
    @Size(max = 128,message = "题目不能超过128个字符")
    private String subject;
    /**
     * 答案集合
     */
    @NotNull(message = "答案不能为空")
    private List<AnswerVO> answers;
    /**
     * 题目难度
     */
    @NotBlank(message = "题目难度不能为空")
    private String difficulty;
    /**
     * 题目类别ID
     */
    @NotBlank(message = "题目类别不能为空")
    private String typeId;
}

