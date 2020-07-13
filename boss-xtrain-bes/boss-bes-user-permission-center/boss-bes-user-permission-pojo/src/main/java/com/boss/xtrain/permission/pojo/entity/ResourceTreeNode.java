package com.boss.xtrain.permission.pojo.entity;

import com.boss.xtrain.common.core.pojo.TreeEntity;
import lombok.*;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :17:32 2020/07/08
 * @Description :资源树状结构节点
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)

public class ResourceTreeNode  extends TreeEntity {
    private String name;
    private List<ResourceTreeNode> children;
}
