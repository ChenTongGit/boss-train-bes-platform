package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.examservice.ExamPaperInfoDTO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperInfoQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;

import java.util.List;

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

    List<ExamPaperInfoDTO> getExamPaperList(ExamPaperInfoQuery examPaperInfoQuery);
}
