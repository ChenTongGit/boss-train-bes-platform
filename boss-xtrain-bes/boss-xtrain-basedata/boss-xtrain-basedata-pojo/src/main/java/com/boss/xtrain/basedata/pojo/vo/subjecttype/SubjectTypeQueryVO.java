package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectTypeQueryVO extends BaseQuery {
    private Long orgId;
    private String name;
    private int pageNum;
    private int pageSize;
    private Date updatedTime;
}
