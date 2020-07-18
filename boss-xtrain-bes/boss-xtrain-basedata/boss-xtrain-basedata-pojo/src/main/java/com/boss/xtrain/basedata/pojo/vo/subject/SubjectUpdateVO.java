package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class SubjectUpdateVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @NotBlank(message = "题型不能为空")
    private String subjectTypeName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectTypeId;
    @NotBlank(message = "题目类别不能为空")
    private String categoryName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    @NotBlank(message = "题目名称不能为空")
    private String name;
    @NotBlank(message = "难度不能为空")
    private String difficulty;
    private String imageUrl;
    private String remark;
    private List<SubjectAnswer> subjectAnswers;
}
