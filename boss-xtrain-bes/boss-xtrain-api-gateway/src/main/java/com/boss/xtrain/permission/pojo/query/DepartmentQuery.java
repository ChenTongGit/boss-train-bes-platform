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
public class DepartmentQuery extends BaseQuery {
    private Long id;
    private String name;

    private String level;

    private Long companyId;
    private String companyName;

    private Long parentId;

    private Long organizationId;
    private String orgName;

    //private Long version;

    private Long userId;
}
