package com.boss.xtrain.basedata.pojo.dto.dictionary;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @author gxr
 * @description 字典DTO
 * @date 2020/7/1
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DictionaryDTO extends BaseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String category;
    private String value;
    private String remark;
}
