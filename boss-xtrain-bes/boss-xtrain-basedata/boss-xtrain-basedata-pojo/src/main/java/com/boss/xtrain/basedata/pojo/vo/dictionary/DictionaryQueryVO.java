package com.boss.xtrain.basedata.pojo.vo.dictionary;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gxr
 * @description DictionaryQueryVO
 * @date 2020/7/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DictionaryQueryVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String category;
    private int pageNum;
    private int pageSize;
    private String value;
    private Long version;
    private String remark;
}
