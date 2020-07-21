package com.boss.xtrain.permission.pojo.dto;

import lombok.*;

/*
 * @Author  :yushiqian
 * @Date    :17:39 2020/07/08
 * @Description :user-role表
 * @Version: 1.0
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserRoleDTO {
//    private Long id;
    private Long userId;
    private Long roleId;

}
