package com.boss.bes.paper.vo.templatemanage;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**模板试题和答案更新对象
 * @author lenovo
 */
@Data
public class TemplateUpdateVO extends BaseVO {
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
    @NotBlank(message = "试卷名不能为空")
    @Length(max = 32,message = "试卷名不能超过32个字符")
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
    /**
     * 试卷描述
     */
    @Length(max = 128,message = "试卷描述不能超过32个字符")
    private String discript;
}

