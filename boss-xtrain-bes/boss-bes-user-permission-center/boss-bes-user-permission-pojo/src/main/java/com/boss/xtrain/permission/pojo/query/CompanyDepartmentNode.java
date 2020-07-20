package com.boss.xtrain.permission.pojo.query;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @author 53534qyq
 * @date 2020.07.15
 */
@Data
public class CompanyDepartmentNode{
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    private String name;
    private List<TreeNode> childList;
}
