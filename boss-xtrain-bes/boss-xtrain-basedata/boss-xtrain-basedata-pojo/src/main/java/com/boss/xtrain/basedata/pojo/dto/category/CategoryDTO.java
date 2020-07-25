package com.boss.xtrain.basedata.pojo.dto.category;

import com.boss.xtrain.common.core.pojo.BaseDTO;
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
public class CategoryDTO extends BaseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Integer status;
    private String remark;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;
}
