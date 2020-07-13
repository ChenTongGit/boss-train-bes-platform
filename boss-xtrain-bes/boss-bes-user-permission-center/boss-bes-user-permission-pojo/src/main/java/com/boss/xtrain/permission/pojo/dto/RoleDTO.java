package com.boss.xtrain.permission.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.*;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :22:46 2020/07/07
 * @Description :role dto封装
 * @Version: 1.0
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoleDTO extends BaseDTO {
    private List<UserDTO> userList;
    private List<ResourceDTO> resourceList;
    private String orgName;
    private String companyName;
    private Long companyId;
    private Long id;
    private Long orgId;
    private String name;
    private String code;
    private String remark;

}
