package com.boss.xtrain.permission.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import lombok.*;

import java.util.Date;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :22:48 2020/07/07
 * @Description :user dto
 * @Version: 1.0
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserDTO extends BaseDTO {
    private Long id;
    private Long positionId;
    private Long departmentId;
    private Long companyId;
    private Long organizationId;
    private  String organizationName;
    private String code;
    private String password;
    private String name;
    private String profilePicture;
    private Byte sex;
    private Date birthday;
    private String tel;
    private String email;
    private String other;
    private String remark;
    private String positionName;
    private String companyName;
    private String departmentName;
    private String updateName;
    private List<RoleDTO> roleList;
}
