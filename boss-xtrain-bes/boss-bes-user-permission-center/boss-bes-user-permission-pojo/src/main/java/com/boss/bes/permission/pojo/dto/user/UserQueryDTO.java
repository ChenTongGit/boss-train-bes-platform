package com.boss.bes.permission.pojo.dto.user;

/*
 * @Author  :yushiqian
 * @Date    :22:50 2020/07/07
 * @Description :user  查询条件  dto
 * @Version: 1.0
 */

import lombok.*;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserQueryDTO {
    private String name;
    private String code;
    private String tel;
    private String roleId;
    private Long companyId;
    private Long departmentId;
    private Long id;

}
