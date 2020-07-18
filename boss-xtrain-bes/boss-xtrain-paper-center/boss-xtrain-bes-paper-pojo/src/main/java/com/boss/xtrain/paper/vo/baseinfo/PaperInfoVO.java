package com.boss.xtrain.paper.vo.baseinfo;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;

/**试卷基本信息的接收对象
 * @author lenovo
 */
@Data
public class PaperInfoVO extends BaseVO {
    private String value;
    private String dictionaryName;

}
