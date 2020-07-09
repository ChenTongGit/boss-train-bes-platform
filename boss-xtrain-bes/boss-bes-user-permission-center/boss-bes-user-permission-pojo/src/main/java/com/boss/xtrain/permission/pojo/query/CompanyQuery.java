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
public class CompanyQuery extends BaseQuery {
    private Long id;
    private String name;

    private Long organizationId;
    private String orgName;

    private Long userId;

    private Long version;
}
