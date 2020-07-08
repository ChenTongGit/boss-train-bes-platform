package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO;

/**
 * 考试发布记录相关API
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 21:03
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamPublishRecordApi extends CommonCRUDApi<ExamPublishRecordDTO, ExamPublishRecordQuery, ExamPublishRecordVO> {
    
    /**
     * 发布考试
     * @author ChenTong
     * @param request 
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Boolean>
     * @date 2020/7/7 22:22
     */
    CommonResponse<Boolean> publishExam(CommonRequest<ExamPublishRecordDTO> request);
}
