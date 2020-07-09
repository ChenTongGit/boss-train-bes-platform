package com.boss.bes.paper.vo.baseinfo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

/**试卷基本信息的接收对象
 * @author lenovo
 */
@Data
public class PaperInfoVO extends BaseVO {
    private String value;
    private String dictionaryName;

}
