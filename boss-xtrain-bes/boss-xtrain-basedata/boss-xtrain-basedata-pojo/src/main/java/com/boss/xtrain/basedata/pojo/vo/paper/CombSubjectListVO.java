package com.boss.xtrain.basedata.pojo.vo.paper;

import com.boss.xtrain.basedata.pojo.vo.subject.SubjectAnswerVO;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**组卷后的试题和答案接收对象
 * @author lenovo
 */
@Data
public class CombSubjectListVO extends BaseVO {

    /**
     * 题目
     */
    private String subjectName;
    /**
     * 题型
     */
    private String subjectTypeId;
    /**
     * 题型名字
     */
    private String subjectTypeName;
    /**
     * 题目难度
     */
    private String difficuty;
    /**
     * 分数
     */
    private BigDecimal score;
    /**
     * 答案集合
     */
    private transient List<SubjectAnswerVO> answerList;
    /**
     * 题目类别
     */
    private String categoryId;
    /**
     * 题目类别名字
     */
    private String categoryName;
}

