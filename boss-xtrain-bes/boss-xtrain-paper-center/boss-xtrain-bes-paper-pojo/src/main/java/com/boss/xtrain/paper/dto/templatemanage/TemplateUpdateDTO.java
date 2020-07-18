package com.boss.xtrain.paper.dto.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.util.List;

/**模板试题集合和答案集合更新对象
 * @author lenovo
 */
@Data
public class TemplateUpdateDTO extends BaseDTO {
    /**
     * 试卷id
     */
    private Long paperId;
    /**
     * 题目集合
     */
    private List<SubjectDTO> subjectList;
    /**
     * 试卷名
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
    /**
     * 试卷描述
     */
    private String discript;
}

