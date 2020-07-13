package com.boss.xtrain.basedata.pojo.dto.category;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "{handler}")
public class CategoryDTO extends BaseVO {
    @NotNull(message = "题目类别名称不能为空")
    private String name;
    private Long parentId;
}
