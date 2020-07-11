package com.boss.xtrain.basedata.pojo.dto.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class SubjectDTO extends BaseEntity {
    private String name;
    private Long subjectTypeId;
    private String subjectTypeName;
    private String categoryName;
    private Long categoryId;
    private String imageUrl;
    private String remark;
    private List<SubjectAnswer> subjectAnswers;
}
