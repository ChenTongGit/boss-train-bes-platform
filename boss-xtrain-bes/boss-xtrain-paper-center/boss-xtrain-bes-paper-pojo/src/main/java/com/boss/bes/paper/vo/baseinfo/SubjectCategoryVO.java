package com.boss.bes.paper.vo.baseinfo;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

/**题目类型接收对象
 * @author lenovo
 */
@Data
public class SubjectCategoryVO extends BaseVO {
    private String subjectId;
    private String name;

}
