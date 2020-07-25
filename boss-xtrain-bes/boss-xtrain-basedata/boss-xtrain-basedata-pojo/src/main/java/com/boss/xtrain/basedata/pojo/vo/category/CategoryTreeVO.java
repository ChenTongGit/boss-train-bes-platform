package com.boss.xtrain.basedata.pojo.vo.category;

import com.boss.xtrain.common.core.pojo.TreeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;


import java.util.List;

@Data
public class CategoryTreeVO {
    private String id;
    private String name;
    private String parentId;
    private String remark;
    private Integer status;
    private Long orgId;
    private Long version;
    private String value;
    private String label;
    private List<CategoryTreeVO> children;

}
