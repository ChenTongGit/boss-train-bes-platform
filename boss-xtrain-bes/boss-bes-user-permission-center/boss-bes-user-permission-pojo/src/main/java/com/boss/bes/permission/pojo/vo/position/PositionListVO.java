package com.boss.bes.permission.pojo.vo.position;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PositionListVO extends BaseVO {
    /**
     * long前端会丢失精度
     */
    private String id;
    private String companyId;
    private String code;
    private String name;
    private String companyName;
}
