package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
public class SystemParamVO extends BaseVO {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    private String paramType;
    private String param;
    private String value;
    private Integer status;
    private Long version;
}
