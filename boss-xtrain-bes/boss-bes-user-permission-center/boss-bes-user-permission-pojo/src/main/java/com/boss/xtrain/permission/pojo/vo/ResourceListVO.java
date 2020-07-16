package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

/*
 * @Author  :yushiqian
 * @Date    :22:52 2020/07/07
 * @Description :表格展示时每行的元素
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class ResourceListVO extends BaseVO {
    private String parentName;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String code;
    private String name;
    private Integer orderIndex;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    private String url;
    private String openImg;
    private String closeImg;
    private Byte resourceType;
    private Byte leaf;

}
