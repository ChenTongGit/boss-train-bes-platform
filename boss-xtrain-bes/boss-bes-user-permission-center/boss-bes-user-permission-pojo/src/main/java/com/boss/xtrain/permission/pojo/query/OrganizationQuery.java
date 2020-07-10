package com.boss.xtrain.permission.pojo.query;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Data
public class OrganizationQuery extends BaseQuery {
    private Long id;
    private String name;

    private Long userId;

    private Long version;
}
