package com.boss.xtrain.permission.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.*;

import java.io.Serializable;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyDTO extends BaseDTO {

    private String orgName;
    private String name;
    private String code;
    private String mnemonicCode;
    private String master;
    private String tax;
    private String fax;
    private String tel;
    private String address;
    private String email;
    private String website;
    private Long version;

}
