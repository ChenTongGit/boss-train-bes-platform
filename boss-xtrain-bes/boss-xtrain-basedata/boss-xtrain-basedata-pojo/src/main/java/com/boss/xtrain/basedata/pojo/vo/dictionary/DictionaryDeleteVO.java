package com.boss.xtrain.basedata.pojo.vo.dictionary;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gxr
 * @description DictionaryDeleteVO
 * @date 2020/7/6
 */
@Getter
@Setter
public class DictionaryDeleteVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String category;
    private Long version;
}
