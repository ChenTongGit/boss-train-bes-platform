package com.boss.xtrain.basedata.pojo.dto.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class DictionaryQueryDTO{
    private Long orgId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String category;
    private String value;
    private Integer status;
    private Long version;
    private String remark;
}
