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
public class CompanyVO extends BaseVO {
    private Long id;
    private Long organizationId;
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
    private Integer status;
    private Long version;
}
