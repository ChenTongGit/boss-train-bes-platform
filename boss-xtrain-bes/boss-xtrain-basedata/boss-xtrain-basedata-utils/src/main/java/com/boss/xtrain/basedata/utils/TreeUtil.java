package com.boss.xtrain.basedata.utils;

import com.boss.xtrain.basedata.pojo.vo.category.CategoryTreeVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {
    private TreeUtil() {
    }

    //获取顶层节点
    public static List<CategoryTreeVO> getTreeList(Long topId, List<CategoryTreeVO> entityList){
        //存储顶层的数据
        List<CategoryTreeVO> resultList = new ArrayList<>();
        Map<Object, CategoryTreeVO> treeMap = new HashMap<>();
        CategoryTreeVO itemTree;
        for(int i=0;i<entityList.size()&&!entityList.isEmpty();i++) {
            itemTree = entityList.get(i);
            //把所有的数据放到map当中，id为key
            treeMap.put(itemTree.getId(),itemTree);
            if(topId == itemTree.getParentId() || itemTree.getParentId() == null) {
                //把顶层数据放到集合中
                resultList.add(itemTree);
            }
        }
        //循环数据，把数据放到上一级的children属性中
        for(int i = 0; i< entityList.size()&&!entityList.isEmpty();i++) {
            itemTree = entityList.get(i);
            //在map集合中寻找父亲
            CategoryTreeVO data = treeMap.get(itemTree.getParentId());
            if(data != null) {
                //判断父亲有没有
                if(data.getChildren() == null) {
                    data.setChildren(new ArrayList<>());
                }
                //把子节点 放到父节点children当中
                resultList.add(itemTree);
                data.setChildren(resultList);
                //data.getChildren().add(itemTree);
                //把放好的数据放回map当中
                treeMap.put(itemTree.getParentId(), data);
            }
        }
        return resultList;
    }

}
