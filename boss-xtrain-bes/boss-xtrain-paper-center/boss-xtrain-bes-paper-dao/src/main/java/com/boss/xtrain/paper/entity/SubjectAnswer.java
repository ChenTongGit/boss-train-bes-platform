package com.boss.xtrain.paper.entity;


import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @version: V1.0
 * @author: zjh
 * @className: SubjectAnswer
 * @packageName: com.boss.bes.paper.entity
 * @description: 包含答案集合的题目实体类
 * @data: 21:04 2020/3/17
 **/
@Data
public class SubjectAnswer extends BaseEntity {
    private Long paperSubjectId;

    private Long paperId;

    private List<PaperSubjectAnswer> answers;

    private String subject;

    private Long categoryId;

    private Long difficult;

    private BigDecimal score;


    private Long typeId;

    private String field1;

    private String field2;

    private String field3;

}

