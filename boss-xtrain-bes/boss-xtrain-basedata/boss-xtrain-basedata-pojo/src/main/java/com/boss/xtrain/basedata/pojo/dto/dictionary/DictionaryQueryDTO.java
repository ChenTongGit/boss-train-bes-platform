package com.boss.xtrain.basedata.pojo.dto.dictionary;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class DictionaryQueryDTO extends BaseQuery {
    private Long orgId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dictionaryId;
    private String dictionaryName;
    private String category;
    private String value;
    private Integer status;
}
