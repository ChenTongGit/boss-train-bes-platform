package com.boss.xtrain.basedata.utils;

import java.util.List;

public interface DataTree<T> {

    /**
     * 获取父节点ID
     * @return
     */
    String getParentId();

    /**
     * 设置子节点
     * @param children
     */
    void setChildren(List<T> children);

    /**
     * 获取子节点
     * @return
     */
    List<T> getChildren();

}
