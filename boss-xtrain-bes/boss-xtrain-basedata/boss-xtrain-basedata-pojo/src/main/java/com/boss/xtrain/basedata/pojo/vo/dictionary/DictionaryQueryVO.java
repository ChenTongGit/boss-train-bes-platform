package com.boss.xtrain.basedata.pojo.vo.dictionary;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DictionaryQueryVO extends BaseVO {
    private String name;
    private String category;
}
