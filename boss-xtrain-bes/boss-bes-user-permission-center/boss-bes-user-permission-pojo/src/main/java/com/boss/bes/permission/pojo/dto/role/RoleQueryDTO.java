package com.boss.bes.permission.pojo.dto.role;

/*
 * @Author  :yushiqian
 * @Date    :22:47 2020/07/07
 * @Description :role查询条件封装dto
 * @Version: 1.0
 */

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class RoleQueryDTO {
    private String name;
    private Long companyId;
    private Long id;

}
