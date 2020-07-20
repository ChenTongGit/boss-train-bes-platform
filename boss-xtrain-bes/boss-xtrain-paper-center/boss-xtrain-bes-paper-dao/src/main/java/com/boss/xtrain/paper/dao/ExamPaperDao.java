package com.boss.xtrain.paper.dao;

import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;
import com.boss.xtrain.paper.entity.Paper;

import java.util.List;

/**
 * 试卷获取操作接口
 */
public interface ExamPaperDao {

    /**
     * 通过试卷id获取试卷完成信息
     * @param queryPaperDTO
     * @return
     */
    ExamPaperDTO getExamPaper(ExamPaperQuery queryPaperDTO);

    List<Paper> getExamPaperInfoList(Paper query);
}
