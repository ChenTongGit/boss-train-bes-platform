package com.boss.xtrain.permission.pojo.query;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class PositionQueryDTO extends BaseDTO {
    private String name;
    private long companyId;
    private  long id;
}
