package com.boss.xtrain.common.core.pojo;

import java.io.Serializable;

/**
 * @author ChenTong
 * @description 树状结构抽象
 * @create 2020-07-03 08:27
 * @since 1.0
 */
public abstract class TreeEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8371318612865748312L;
    private Long id;
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


}
