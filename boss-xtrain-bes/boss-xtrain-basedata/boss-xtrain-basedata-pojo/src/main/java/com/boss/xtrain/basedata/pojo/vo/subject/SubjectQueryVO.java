package com.boss.xtrain.basedata.pojo.vo.subject;
;
import lombok.Data;

import java.util.Date;


@Data
public class SubjectQueryVO{
    private String categoryName;
    private String subjectTypeName;
    private String name;
    private Long orgId;
    private Long companyId;
    private int pageNum;
    private int pageSize;
    private Date updatedTime;
}
