package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentVO extends BaseVO {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long companyId;

    private String companyName;
    private String name;
    private String mnemonicCode;
    private String code;
    private String level;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long parentId;
    private String parentName;
    private String master;
    private String description;
    private Integer status;
    private Long version;
}
