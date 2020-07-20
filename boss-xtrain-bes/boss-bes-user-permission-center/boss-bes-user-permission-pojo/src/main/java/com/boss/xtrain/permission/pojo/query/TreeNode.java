package com.boss.xtrain.permission.pojo.query;

import lombok.Data;

import java.util.List;

/**
 * @author 53534qyq
 * @date 2020.07.11
 */
@Data
public class TreeNode{
    //    private String id;
//    private String name;
//    private String parentId;
//    private Boolean isLeaf;
//    private Boolean disable;
//
//    private List children;
//
//    private String path;
//    private String component;
    private String id;
    private String name;
    private String companyId;

    private String companyName;
    private String parentId;

    private List<TreeNode> childList;
}
