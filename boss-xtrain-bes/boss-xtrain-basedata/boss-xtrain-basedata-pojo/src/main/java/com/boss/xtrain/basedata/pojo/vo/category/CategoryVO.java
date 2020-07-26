package com.boss.xtrain.basedata.pojo.vo.category;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author gxr
 * @description categroyvo类
 * @date 2020/7/1
 */
@Data
public class CategoryVO{
    private String id;
    @NotBlank(message = "题目类别名称不能为空")
    private String name;
    private String parentId;
    private String remark;
    private Integer status;
    private Long version;
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long orgId;
    protected Long companyId;
    protected Long createdBy;
    protected Date createdTime;
    protected Long updatedBy;
    protected Date updatedTime;

}
