package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectTypeVO extends BaseVO {
    private Long id;
    @NotBlank(message = "题型名称不能为空")
    private String name;
    private String attribute;
    private String remark;
    private Long version;
}
