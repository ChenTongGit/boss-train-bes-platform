package com.boss.bes.permission.pojo.dto.resource;

/*
 * @Author  :yushiqian
 * @Date    :22:45 2020/07/07
 * @Description :resource 查询条件封装dto
 * @Version: 1.0
 */

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResourceQueryDTO {
    private String name;
    private Long parentId;
    private String parentName;
    private Long id;

}
