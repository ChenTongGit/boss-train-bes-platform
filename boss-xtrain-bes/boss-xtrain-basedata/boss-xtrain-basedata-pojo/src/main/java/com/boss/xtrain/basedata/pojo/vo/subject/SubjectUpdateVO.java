package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class SubjectUpdateVO extends BaseVO {
    private Long id;
    private String name;
    private Long subjectTypeId;
    private Long categoryId;
    private String subjectName;
    private Long difficulty;
    private String imageUrl;
    private String remark;
    private List<SubjectAnswer> subjectAnswer;
}
