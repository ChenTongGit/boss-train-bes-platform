package com.boss.xtrain.paper.dto.examservice;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import lombok.Data;

import java.util.List;

/**
 * 考试服务查询对象
 */
@Data
public class ExamServiceDTO extends BaseDTO {
    List<Long> paperIdList;
    Long paperId;
    List<Long> subjectIdList;
}

