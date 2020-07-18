package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordDetailQuery;
import com.boss.xtrain.exam.pojo.dto.query.ExamReportQuery;
import com.boss.xtrain.exam.pojo.dto.query.ReportDetailQuery;
import com.boss.xtrain.exam.pojo.vo.ReportDataItemVO;
import com.boss.xtrain.exam.pojo.vo.ReportDataListVO;
/**
 * 考试报表api
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/13 22:56
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamReportApi {


    CommonResponse<CommonPage<ReportDataItemVO>> queryExamReport(CommonRequest<CommonPageRequest<ReportDetailQuery>> request);

    CommonResponse<CommonPage<ReportDataListVO>> doQueryExamReport(CommonRequest<CommonPageRequest<ExamReportQuery>> request);
}
