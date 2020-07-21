package com.boss.xtrain.paper.dto.papermanage;

import com.boss.xtrain.common.core.pojo.BaseDTO;

import lombok.Data;

import java.util.List;
/**
 * @version: V1.0
 * @className: PaperUpdateDTO
 * @packageName: com.boss.bes.paper.pojo.dto.papermanage
 * @description: 试卷试题集合和答案集合更新对象
 **/

@Data
public class PaperUpdateDTO extends BaseDTO {
    /**
     * 试卷id
     */
    private Long paperId;
    /**
     * 题目集合
     */
    private List<SubjectDTO> subjectList;
    /**
     * 试卷名
     */
    private String paperName;
    /**
     * 试卷类型
     */
    private Long paperType;
    /**
     * 试卷难度
     */
    private Long difficulty;
    /**
     * 试卷描述
     */
    private String discript;

}

