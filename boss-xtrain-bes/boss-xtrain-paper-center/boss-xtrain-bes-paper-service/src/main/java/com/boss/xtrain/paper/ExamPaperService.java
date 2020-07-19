package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;

/**
 *
 */
public interface ExamPaperService {

    /**
     * 通过试卷id获取所有试卷信息
     * @param examPaperQuery 查询条件:试卷id
     * @return
     */
    ExamPaperDTO getExamPaper(ExamPaperQuery examPaperQuery);
}
