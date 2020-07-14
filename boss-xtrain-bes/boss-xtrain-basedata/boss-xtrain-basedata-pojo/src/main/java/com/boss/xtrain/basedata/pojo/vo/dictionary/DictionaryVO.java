package com.boss.xtrain.basedata.pojo.vo.dictionary;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DictionaryVO extends BaseVO {
    private Long id;
    private String name;
    private String categoryName;
    private String value;
    private Date updateTime;
    private Long version;
}
