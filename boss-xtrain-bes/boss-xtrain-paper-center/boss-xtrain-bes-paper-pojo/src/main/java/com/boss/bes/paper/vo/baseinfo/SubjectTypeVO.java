package com.boss.bes.paper.vo.baseinfo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

/**题型接收对象
 * @author lenovo
 */
@Data
public class SubjectTypeVO extends BaseVO {
    private String id;
    private String typeName;
    private String attribute;
}
