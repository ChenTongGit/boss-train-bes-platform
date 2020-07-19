package com.boss.xtrain.exam.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.ServiceException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.service.PaperFeign;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 试卷服务调用异常处理
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/18 22:49
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Component
@Slf4j
public class PaperFallBack implements PaperFeign {
    /**
     * t通过考试试卷的id获取试卷的试题信息
     *
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.paper.dto.examservice.ExamPaperDTO>
     * @author ChenTong
     * @date 2020/7/18 19:34
     */
    @Override
    public CommonResponse<ExamPaperDTO> getExamPaper(CommonRequest<ExamPaperQuery> request) {
        log.error("试卷服务调用出错");
        throw new BusinessException(BusinessError.EXAM_PAPER_PREVIEW_ERR);
    }
}
