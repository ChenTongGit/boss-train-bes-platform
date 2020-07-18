package com.boss.xtrain.paper.vo.fastcomb;

import com.boss.xtrain.paper.vo.BaseVO;
import lombok.Data;

import java.math.BigDecimal;

/**组卷明细对象
 * @author lenovo
 */
@Data
public class CombConfigItemVO extends BaseVO {
    /**
     *  配置明细id
     */
    private String combExamConfigId;
    /**
     * 题目类型
     */
    private String categoryId;
    /**
     * 题型ID
     */
    private String subjectTypeId;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 难度
     */
    private String difficulty;
    /**
     * 分值
     */
    private BigDecimal score;
    /**
     * 题目类别名字
     */
    private String categoryName;
    /**
     * 题型名字
     */
    private String typeName;
    /**
     * 难度名
     */
    private String difficultyName;

}

