package com.boss.xtrain.paper.vo.baseinfo;


import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**获取试卷基本信息和题目基本信息
 * @author lenovo
 */
@Data
public class CombInfoQueryVO extends BaseVO {
    /**
     * Description: 字段名
     */
    @NotBlank(message = "字段名不能为空")
    private String category;

}

