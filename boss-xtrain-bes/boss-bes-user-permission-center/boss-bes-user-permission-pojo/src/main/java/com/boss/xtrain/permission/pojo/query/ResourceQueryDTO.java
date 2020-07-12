package com.boss.xtrain.permission.pojo.query;

/*
 * @Author  :yushiqian
 * @Date    :22:45 2020/07/07
 * @Description :resource 查询条件封装dto
 * @Version: 1.0
 */

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResourceQueryDTO extends BaseQuery {
    private String name;
    private Long parentId;
    private String parentName;
    private Long id;

}
