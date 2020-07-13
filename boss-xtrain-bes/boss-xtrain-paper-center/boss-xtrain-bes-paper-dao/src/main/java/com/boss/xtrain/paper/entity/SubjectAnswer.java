package com.boss.xtrain.paper.entity;


import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

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

    private Long difficulty;

    private BigDecimal score;


    private Long typeId;

    private String field1;

    private String field2;

    private String field3;

}

