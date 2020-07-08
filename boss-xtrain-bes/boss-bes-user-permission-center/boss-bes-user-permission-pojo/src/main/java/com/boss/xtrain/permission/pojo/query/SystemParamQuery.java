package com.boss.xtrain.permission.pojo.query;

import com.boss.xtrain.common.core.pojo.BaseQuery;
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
public class SystemParamQuery extends BaseQuery {
    private Long id;
    private Long organizationId;

    private String paramType;
    private String param;
    private Integer status;
}
