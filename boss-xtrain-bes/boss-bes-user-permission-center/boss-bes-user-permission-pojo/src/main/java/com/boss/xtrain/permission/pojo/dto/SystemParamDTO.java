package com.boss.xtrain.permission.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.*;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SystemParamDTO extends BaseDTO {
    private Long id;
    private String paramType;
    private String param;
    private String value;
    private Integer status;
}
