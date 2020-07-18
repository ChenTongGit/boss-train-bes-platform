package com.boss.xtrain.permission.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.*;

/*
 * @Author  :yushiqian
 * @Date    :22:43 2020/07/07
 * @Description :resource的dto对象
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class ResourceDTO extends BaseDTO {
    private String parentName;
    private Long id;
    private String code;
    private String name;
    private Integer orderIndex;
    private Long parentId;
    private String url;
    private String openImg;
    private String closeImg;
    private Byte resourceType;
    private Byte leaf;
    private String remark;
    //
    private String tenantName;
}
