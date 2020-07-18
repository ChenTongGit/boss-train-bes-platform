package com.boss.xtrain.paper.vo.fastcomb;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;

/**组卷项对象
 * @author lenovo
 */
@Data
public class CombConfigVO extends BaseVO {
    /**
     * 组卷配置ID
     */
    private Long combExamConfigId;
    /**
     * 组卷配置名
     */
    private String name;
    /**
     * 难度ID
     */
    private String difficuty;
    /**
     * 备注
     */
    private String remark;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 修改人
     */
    private String updatedByName;
    /**
     * 难度
     */
    private String difficutyName;

}

