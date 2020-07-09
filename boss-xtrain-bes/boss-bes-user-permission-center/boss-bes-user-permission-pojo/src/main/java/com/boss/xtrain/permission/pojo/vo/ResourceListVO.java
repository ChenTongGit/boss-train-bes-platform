package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
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
    private Long id;
    private String code;
    private String name;
    private Integer orderIndex;
    private String parentId;
    private String url;
    private String openImg;
    private String closeImg;
    private Byte resourceType;
    private Byte leaf;

}
