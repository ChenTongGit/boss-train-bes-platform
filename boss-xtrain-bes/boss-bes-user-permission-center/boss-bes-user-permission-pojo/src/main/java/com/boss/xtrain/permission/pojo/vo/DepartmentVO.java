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
public class DepartmentVO extends BaseVO {
    private Long id;
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
    private Integer status;
    private Long version;
}
