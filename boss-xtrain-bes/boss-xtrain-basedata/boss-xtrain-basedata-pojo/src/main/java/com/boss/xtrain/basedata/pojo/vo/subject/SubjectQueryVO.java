package com.boss.xtrain.basedata.pojo.vo.subject;
;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class SubjectQueryVO{
    private String categoryName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    private String subjectTypeName;
    private String name;
    private Long orgId;
    private Long companyId;
}
