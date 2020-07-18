package com.boss.xtrain.paper.dao;

import com.boss.xtrain.paper.dto.examservice.ExamServiceQueryPaperDTO;
import com.boss.xtrain.paper.dto.examservice.PaperAllMsgDTO;
import com.boss.xtrain.paper.vo.examservice.PaperQueryVO;

public interface ExamPaperDao {
    PaperAllMsgDTO getOnePaperMsg(ExamServiceQueryPaperDTO queryPaperDTO);
}
