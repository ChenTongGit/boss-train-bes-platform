package com.boss.xtrain.permission.pojo.query;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @author 53534qyq
 * @date 2020.07.11
 */
@Data
public class TreeNode {

    @JsonSerialize(using= ToStringSerializer.class)
    private String id;
    private String name;

    @JsonSerialize(using= ToStringSerializer.class)
    private String companyId;

    @JsonSerialize(using= ToStringSerializer.class)
    private String parentId;

    private List<TreeNode> childList;
}
