package com.boss.xtrain.paper.impl;

import com.boss.xtrain.papaer.annotation.TryCatch;
import com.boss.xtrain.paper.ExamService;
import com.boss.xtrain.paper.dao.ExamPaperDao;
import com.boss.xtrain.paper.dto.examservice.ExamServiceQueryPaperDTO;
import com.boss.xtrain.paper.dto.examservice.PaperAllMsgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamPaperDao examPaperDao;
    @TryCatch
    @Override
    public PaperAllMsgDTO getOnePaperMsg(ExamServiceQueryPaperDTO examServiceQueryPaperDTO) {
        return examPaperDao.getOnePaperMsg(examServiceQueryPaperDTO);
    }
}
