package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.examservice.ExamServiceQueryPaperDTO;
import com.boss.xtrain.paper.dto.examservice.PaperAllMsgDTO;

/**
 *
 */
public interface ExamService {
    PaperAllMsgDTO getOnePaperMsg(ExamServiceQueryPaperDTO examServiceQueryPaperDTO);
}
