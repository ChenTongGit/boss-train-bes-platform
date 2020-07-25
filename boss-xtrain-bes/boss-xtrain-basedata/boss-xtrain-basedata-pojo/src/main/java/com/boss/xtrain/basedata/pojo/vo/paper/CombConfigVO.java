package com.boss.xtrain.basedata.pojo.vo.paper;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

/**组卷后的配置接收对象
 * @author lenovo
 */
@Data
public class CombConfigVO extends BaseVO {
    private String combExamConfigId;
    private String name;
    private String difficulty;
    private String difficultyName;
    private String remark;
    private String companyName;
    private String updateByName;

}
