package com.boss.xtrain.basedata.pojo.dto.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class SubjectUpdateDTO extends BaseEntity {
    private String subjectTypeName;
    private String categoryName;
    /**
     * 题目
     */
    private String name;
    /**
     * 图片路径
     */
    private String imageUrl;
    /**
     * 难度ID
     */
    private Long difficulty;
    /**
     * 备注
     */
    private String remark;
    private List<SubjectAnswer> subjectAnswers;
}
