package com.boss.xtrain.permission.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
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
public class OrganizationDTO extends BaseDTO {
    private Long id;
    private String name;
    private String code;
    private String master;
    private String tel;
    private String address;
    private Integer status;
}
