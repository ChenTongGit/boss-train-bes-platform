package com.boss.xtrain.paper.vo.papermanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 更新试卷试题和答案对象
 */
@Data
public class PaperUpdateVO extends BaseVO {
    /**
     * 试卷id
     */
    @NotBlank(message = "试卷ID不能为空")
    private String paperId;
    /**
     * 题目集合
     */
    @NotBlank(message = "题目集合不能为空")
    private List<SubjectVO> subjectList;
    /**
     * 试卷名
     */
    private String paperName;
    /**
     * 试卷类型
     */
    private String paperType;
    /**
     * 试卷难度
     */
    private String difficulty;
    /**
     * 试卷描述
     */
    private String discript;

}

