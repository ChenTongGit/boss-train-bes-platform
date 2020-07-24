package com.boss.xtrain.basedata.pojo.vo.dictionary;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author gxr
 * @description DictionaryUpdateVO
 * @date 2020/7/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DictionaryUpdateVO extends BaseVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @NotBlank(message = "字典名称不能为空")
    private String name;
    @NotBlank(message = "字典类型不能为空")
    private String category;
    @NotBlank(message = "字典值不能为空")
    private String value;
    private String remark;
}
