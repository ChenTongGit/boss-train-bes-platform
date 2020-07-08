package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.util.Date;

@Data
public class SubjectTypeVO extends BaseVO {
    private Long id;
    private String name;
    private String attribute;
    private Date updateTime;
    private Long version;
}
