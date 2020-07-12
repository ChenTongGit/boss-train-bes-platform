package com.boss.xtrain.permission.pojo.query;

/*
 * @Author  :yushiqian
 * @Date    :22:47 2020/07/07
 * @Description :role查询条件封装dto
 * @Version: 1.0
 */

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class RoleQueryDTO extends BaseQuery {
    private String name;
    private Long companyId;
    private Long id;

}
