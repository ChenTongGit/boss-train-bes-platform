package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

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

    /**
     * 条件查询并分页
     * @author ChenTong
     * @param request 
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.common.core.http.CommonPage<com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO>>
     * @date 2020/7/8 21:34
     */
    CommonResponse<CommonPage<ExamPublishRecordVO>> findAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<ExamPublishRecordQuery>> request);
}
