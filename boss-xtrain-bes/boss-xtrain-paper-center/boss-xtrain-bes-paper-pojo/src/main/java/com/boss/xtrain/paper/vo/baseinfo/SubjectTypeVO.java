package com.boss.xtrain.paper.vo.baseinfo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

/**题型接收对象
 * @author lenovo
 */
@Data
public class SubjectTypeVO extends BaseVO {
    private String subjectId;
    private String typeName;
    private String attribute;
}
