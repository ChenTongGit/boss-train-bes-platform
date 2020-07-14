package com.boss.xtrain.permission.pojo.query;

import com.boss.xtrain.common.core.pojo.BaseQuery;
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
public class CompanyQuery extends BaseQuery {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    private String name;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long organizationId;
    private String orgName;

    private Long userId;

    //private Long version;
}
