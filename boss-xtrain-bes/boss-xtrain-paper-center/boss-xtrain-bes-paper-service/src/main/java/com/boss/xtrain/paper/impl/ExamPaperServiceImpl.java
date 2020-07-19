package com.boss.xtrain.paper.impl;

import com.boss.xtrain.papaer.annotation.TryCatch;
import com.boss.xtrain.paper.ExamPaperService;
import com.boss.xtrain.paper.dao.ExamPaperDao;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    private ExamPaperDao examPaperDao;

    @TryCatch
    @Override
    public ExamPaperDTO getExamPaper(ExamPaperQuery examPaperQuery) {
        return examPaperDao.getExamPaper(examPaperQuery);
    }
}
