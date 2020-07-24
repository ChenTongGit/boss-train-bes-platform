package com.boss.xtrain.basedata.pojo.vo.category;

import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    protected Long orgId;
    protected Long companyId;
    protected Long createdBy;
    protected Date createdTime;
    protected Long updatedBy;
    protected Date updatedTime;

}
