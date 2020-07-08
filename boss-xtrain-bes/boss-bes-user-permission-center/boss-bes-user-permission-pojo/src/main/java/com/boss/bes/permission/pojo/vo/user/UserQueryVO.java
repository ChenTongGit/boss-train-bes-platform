package com.boss.bes.permission.pojo.vo.user;

/*
 * @Author  :yushiqian
 * @Date    :17:22 2020/07/08
 * @Description :user前端查询元素
 * @Version: 1.0
 */

import lombok.*;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserQueryVO {
    private String name;
    private String code;
    private String tel;
    private String roleId;
    private String companyId;
    private Long departmentId;
    private Long id;

}
