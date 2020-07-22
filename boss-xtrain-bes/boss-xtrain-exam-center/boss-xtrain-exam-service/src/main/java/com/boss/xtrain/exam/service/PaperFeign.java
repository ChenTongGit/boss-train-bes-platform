package com.boss.xtrain.exam.service;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.service.impl.PaperFallBack;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperInfoDTO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperInfoQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 试卷服务调用
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/18 18:47
 * @copyright
 * @modified
 * @see
 * @since
 **/
@FeignClient(name = "boss-bes-paper", fallback = PaperFallBack.class)
@Component
public interface PaperFeign {

    /**
     * 通过考试试卷的id获取试卷的试题信息
     * @author ChenTong
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.paper.dto.examservice.ExamPaperDTO>
     * @date 2020/7/18 19:34
     */
    @PostMapping("/education/bes/v1/exam/queryOnePaper")
    CommonResponse<ExamPaperDTO> getExamPaper(CommonRequest<ExamPaperQuery> request);

    /**
     * 获取试卷列表
     * @author ChenTong
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.util.List<com.boss.xtrain.paper.dto.examservice.ExamPaperInfoDTO>>
     * @date 2020/7/20 6:55
     */
    @PostMapping("/education/bes/v1/exam/queryAllPaper")
    CommonResponse<List<ExamPaperInfoDTO>> getExamPaperInfoList(CommonRequest<ExamPaperInfoQuery> request);
}
