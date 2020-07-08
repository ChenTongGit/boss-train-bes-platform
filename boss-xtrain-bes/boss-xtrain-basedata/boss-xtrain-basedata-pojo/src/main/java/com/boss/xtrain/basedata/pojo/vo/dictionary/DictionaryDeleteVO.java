package com.boss.xtrain.basedata.pojo.vo.dictionary;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictionaryDeleteVO extends BaseVO {
    private Long id;
    private String name;
    private Long version;
}
