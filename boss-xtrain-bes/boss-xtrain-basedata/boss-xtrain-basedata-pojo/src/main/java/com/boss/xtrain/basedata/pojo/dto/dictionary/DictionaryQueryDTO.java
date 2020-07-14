package com.boss.xtrain.basedata.pojo.dto.dictionary;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

@Data
public class DictionaryQueryDTO extends BaseQuery {
    private Long orgId;
    private Long dictionaryId;
    private String dictionaryName;
    private String category;
    private String value;
    private Integer status;
}
