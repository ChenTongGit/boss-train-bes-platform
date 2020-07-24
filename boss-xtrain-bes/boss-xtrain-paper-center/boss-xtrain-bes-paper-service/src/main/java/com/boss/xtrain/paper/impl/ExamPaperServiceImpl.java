package com.boss.xtrain.paper.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.annotation.TryCatch;
import com.boss.xtrain.paper.ExamPaperService;
import com.boss.xtrain.paper.dao.ExamPaperDao;
import com.boss.xtrain.paper.dto.examservice.ExamPaperInfoDTO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperInfoQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;
import com.boss.xtrain.paper.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    private ExamPaperDao examPaperDao;

    @TryCatch
    @Override
    public ExamPaperDTO getExamPaper(ExamPaperQuery examPaperQuery) {
        return examPaperDao.getExamPaper(examPaperQuery);
    }

    @Override
    public List<ExamPaperInfoDTO> getExamPaperList(ExamPaperInfoQuery examPaperInfoQuery) {
        Paper query = new Paper();
        PojoUtils.copyProperties(examPaperInfoQuery, query);
        List<Paper> papers = this.examPaperDao.getExamPaperInfoList(query);
        List<ExamPaperInfoDTO> examPaperInfoDTOS = PojoUtils.copyListProperties(papers,ExamPaperInfoDTO::new);
        return examPaperInfoDTOS;
    }
}
