package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.pojo.dto.MarkingSubmitDTO;
import com.boss.xtrain.exam.pojo.dto.MarkingTempListDTO;
import com.boss.xtrain.exam.pojo.dto.query.MarkingQuery;
import com.boss.xtrain.exam.pojo.vo.MarkingDataListVO;

/**
 * 考试评卷管理Api
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/14 22:22
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamEvaluateApi {

    /**
     * 获取阅卷部分的考试记录列表
     * @author ChenTong
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.common.core.http.CommonPage<com.boss.xtrain.exam.pojo.vo.MarkingDataListVO>>
     * @date 2020/7/14 22:27
     */
    CommonResponse<CommonPage<MarkingDataListVO>> doQueryExamRecord(CommonRequest<CommonPageRequest<MarkingQuery>> request);


    /**
     * 临时保存回传的阅卷结果信息
     * @author ChenTong
     * @param request 请求
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Boolean>
     * @date 2020/7/16 14:52
     */
    CommonResponse<Boolean> tempMarkingRecord(CommonRequest<MarkingTempListDTO> request);

    /**
     * 提交批卷记录
     *
     * @param request
     * @return
     */
    CommonResponse<Boolean> submitEvaluate(CommonRequest<MarkingSubmitDTO> request);
}
