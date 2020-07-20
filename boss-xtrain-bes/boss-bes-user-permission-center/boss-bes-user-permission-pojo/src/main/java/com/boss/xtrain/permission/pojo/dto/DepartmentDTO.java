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
public class DepartmentDTO extends BaseDTO {
    private Long companyId;
    private String companyName;
    private String name;
    private String mnemonicCode;
    private String code;
    private String level;
    private Long parentId;
    private String parentName;
    private String master;
    private String description;
    private Long version;
}
