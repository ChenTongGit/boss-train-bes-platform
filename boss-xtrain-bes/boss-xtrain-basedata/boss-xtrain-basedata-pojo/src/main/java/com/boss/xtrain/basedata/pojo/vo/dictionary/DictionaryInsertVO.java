package com.boss.xtrain.basedata.pojo.vo.dictionary;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictionaryInsertVO extends BaseVO {
    private String name;
    private String categoryName;
    private String value;
}
