package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.api.ExamRecordApi;
import com.boss.xtrain.exam.pojo.dto.ExamRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.vo.ExamRecordVO;
import com.boss.xtrain.exam.service.ExamRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考试记录逻辑控制器
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/11 14:57
 * @copyright
 * @modified
 * @see
 * @since
 **/
@RestController
@RequestMapping(CommonConstant.BASIC_URL+"/examRecord")
public class ExamRecordController extends BaseController implements ExamRecordApi {

    @Autowired
    private ExamRecordService examRecordService;
    /**
     * 根据查询条件获取所有的考试记录 companyID
     *
     * @param request
     * @return CommonResponse<CommonPage < ExamRecordVO>>
     * @author ChenTong
     * @date 2020/7/11 0:37
     */
    @Override
    @ApiOperation(value = "获取答卷")
    public CommonResponse<CommonPage<ExamRecordVO>> findExamRecordByPage(@Valid CommonRequest<CommonPageRequest<ExamRecordQuery>> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<ExamRecordDTO> examRecordDTOS = this.examRecordService.queryForCondition(request.getBody().getQuery());
        List<ExamRecordVO> examRecordVOS = PojoUtils.copyListProperties(examRecordDTOS, ExamRecordVO::new);
        return buildPageResponse(page,examRecordVOS);
    }
}
