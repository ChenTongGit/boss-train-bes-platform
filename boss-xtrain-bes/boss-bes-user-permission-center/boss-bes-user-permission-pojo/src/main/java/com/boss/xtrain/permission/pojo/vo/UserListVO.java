package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.util.Date;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:59 2020/07/08
 * @Description :user展示元素
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserListVO extends BaseVO {
    private List<RoleListVO> roleList;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long companyId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long positionId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long departmentId;
    private String companyName;
    private String positionName;
    private String departmentName;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long organizationId;
    private  String organizationName;
    private String updateName;
    private String profilePicture;
    private String name;
    private String code;
    private String password;
    private Byte sex;
    private Date birthday;
    private String tel;
    private String email;
    private String other;

}
