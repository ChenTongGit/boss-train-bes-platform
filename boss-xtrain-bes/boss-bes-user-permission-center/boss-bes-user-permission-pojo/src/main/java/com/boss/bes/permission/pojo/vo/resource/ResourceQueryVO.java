package com.boss.bes.permission.pojo.vo.resource;

import lombok.*;

/*
 * @Author  :yushiqian
 * @Date    :22:55 2020/07/07
 * @Description :resource 查询条件的前端展示元素
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ResourceQueryVO {
    private String name;
    private Long parentId;
    private String parentName;
    private Long id;

}
