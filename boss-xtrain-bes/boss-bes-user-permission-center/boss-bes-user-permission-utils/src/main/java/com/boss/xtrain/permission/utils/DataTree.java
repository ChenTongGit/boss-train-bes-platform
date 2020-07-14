package com.boss.xtrain.permission.utils;

import java.util.List;

/**
 * @Author：GuoShengWei
 * @Description：树形菜单工具类
 * @Date：Created in 2019/12/15 22:36
 */
public interface DataTree<T> {

    /**
     * 获取ID
     * @return
     */
    Long getId();

    /**
     * 获取父节点ID
     * @return
     */
    String getParentId();

    /**
     * 设置子节点集合
     * @param children
     */
    void setChildren(List<T> children);

    /**
     * 获取子节点集合
     * @return
     */
    List<T> getChildren();

    String getPath();

    String getComponent();

    void setComponent(String component);

}

