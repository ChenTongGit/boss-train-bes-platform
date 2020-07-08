package com.boss.xtrain.basedata.pojo.vo.subject;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectUpdateVO extends BaseVO {
    private Long id;
    private String name;
    private Long subjectTypeId;
    private Long categoryId;
    private Long version;
    private String imageUrl;
    private List<SubjectAnswer> subjectAnswer;
}
