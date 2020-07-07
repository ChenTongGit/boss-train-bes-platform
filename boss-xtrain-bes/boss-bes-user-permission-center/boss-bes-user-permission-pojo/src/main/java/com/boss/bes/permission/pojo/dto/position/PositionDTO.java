package com.boss.bes.permission.pojo.dto.position;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.*;

/*
 * @Author yushiqian
 * @Date    :14:19 2020/07/07
 * @Description :postion的dto
 * @Version: 1.o
 */

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PositionDTO extends BaseDTO {
    private long id;
    private long comanyId;
    private String companyName;
    private String code;
    private String name;
    private String remark;
}
