package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PositionListVO extends BaseVO {
    private Long id;
    private Long companyId;
    private String code;
    private String name;
    private String companyName;
}
