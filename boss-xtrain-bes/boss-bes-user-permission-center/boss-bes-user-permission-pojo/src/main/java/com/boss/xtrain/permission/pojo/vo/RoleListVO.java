package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.boss.xtrain.permission.pojo.vo.UserListVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:29 2020/07/08
 * @Description :role 展现表格中的元素设计
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class RoleListVO extends BaseVO {
    private List<ResourceListVO> resourceList;
    private List<UserListVO> userList;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long organizationId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long companyId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private String code;
    private String companyName;
    private String organizationName;

}
