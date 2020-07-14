package com.boss.xtrain.permission.pojo.query;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class PositionQueryDTO extends BaseQuery {
    private String name;
    private long companyId;
    private  long id;
}
