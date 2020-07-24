package com.boss.xtrain.basedata.pojo.vo.dictionary;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * @author gxr
 * @description 字典VO
 * @date 2020/7/6
 */
@Getter
@Setter
public class DictionaryVO extends BaseVO {
    /**
     * 字典id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 字典名称
     */
    private String name;
    /**
     * 字典类别
     */
    private String category;
    /**
     * 字典值
     */
    private String value;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 版本
     */
    private Long version;
}
