package com.boss.xtrain.basedata.pojo.dto.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SubjectInsertDTO extends BaseEntity {
    private String name;
    @NotNull
    private String subjectTypeName;
    @NotNull
    private String categoryName;
    private String imageUrl;
    private Long difficult;
    private String remark;
    private List<SubjectAnswer> subjectAnswers;

}
