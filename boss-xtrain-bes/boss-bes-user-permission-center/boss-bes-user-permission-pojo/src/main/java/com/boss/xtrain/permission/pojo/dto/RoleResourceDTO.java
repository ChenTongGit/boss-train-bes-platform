package com.boss.xtrain.permission.pojo.dto;

import lombok.*;

/*
 * @Author  :yushiqian
 * @Date    :17:37 2020/07/08
 * @Description :role-resource表
 * @Version: 1.0
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RoleResourceDTO {
    private Long id;
    private Long roleId;
    private Long resourceId;

}
