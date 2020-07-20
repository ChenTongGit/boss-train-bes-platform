package com.boss.xtrain.permission.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 53534qyq
 * @date 2020.07.12
 */
public class TreeUtils {
    public static <T extends DataTree<T>> List<T> getTreeList(List<T> entityList) {
        List<T> resultList = new ArrayList<>();
        Map<Object, T> treeMap = new HashMap<>();
        T itemTree;
        for (int i = 0; i < entityList.size() && !entityList.isEmpty(); i++) {
            itemTree = entityList.get(i);
            //把所有的数据放到treeMap中，id为key
            treeMap.put(itemTree.getId(), itemTree);
            //把顶层节点放到集合resultList中
            fillComponent(itemTree, resultList);
        }

        //循环数据，把数据放到上一级的childen属性中
        for (int i = 0; i < entityList.size() && !entityList.isEmpty(); i++) {
            itemTree = entityList.get(i);
            T data = treeMap.get(itemTree.getParentId());
            // 不等于null，也就意味着有父节点
            fillData(data, itemTree, treeMap);
        }
        return resultList;
    }

    private static <T extends DataTree<T>> void fillComponent(T itemTree, List<T> resultList){
        if (itemTree.getParentId() == null) {
            if(StringUtils.isNotEmpty(itemTree.getComponent())){
                itemTree.setComponent("Layout");
            }
            resultList.add(itemTree);
        }
    }

    private static <T extends DataTree<T>> void fillData(T data, T itemTree, Map<Object, T> treeMap){
        if (data != null) {
            if (data.getChildren() == null) {
                data.setChildren(new ArrayList<>());
            }
            if(StringUtils.isNotEmpty(itemTree.getComponent())){
                itemTree.setComponent(data.getPath()+"/"+itemTree.getComponent());
            }

            //把子节点 放到父节点children当中
            data.getChildren().add(itemTree);
            //把放好的数据放回map当中
            treeMap.put(itemTree.getParentId(), data);
        }
    }
}
