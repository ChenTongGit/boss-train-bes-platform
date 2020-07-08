package com.boss.bes.permission.pojo.vo.role;

/*
 * @Author  :yushiqian
 * @Date    :16:55 2020/07/08
 * @Description :查询条件前端封装 role
 * @Version: 1.0
 */

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RoleQueryVO {
    private String name;
    private Long companyId;
    private Long id;

}
