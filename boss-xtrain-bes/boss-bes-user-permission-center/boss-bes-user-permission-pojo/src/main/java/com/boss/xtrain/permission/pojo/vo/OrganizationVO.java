package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
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
public class OrganizationVO extends BaseVO {
    private Long id;
    private String name;
    private String code;
    private String master;
    private String tel;
    private String address;
    private Integer status;
    private Long version;
}
