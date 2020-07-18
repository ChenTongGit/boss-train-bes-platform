package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.api.ExamPublishRecordApi;
import com.boss.xtrain.exam.pojo.dto.*;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO;
import com.boss.xtrain.exam.service.ExamPublishRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 考试记录逻辑控制类
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 22:08
 * @copyright
 * @modified
 * @see
 * @since
 **/
@RestController
@RequestMapping(CommonConstant.BASIC_URL+"/examPublishRecord")
@Api(value = "考试发布记录Controller" , tags = {"考试发布记录操作接口"})
@Slf4j
public class ExamPublishRecordController extends BaseController implements ExamPublishRecordApi {

    @Autowired
    private ExamPublishRecordService examPublishRecordService;

    /**
     * 添加新的数据
     * @param request 请求报文对象，传递dto
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @ApiOperation(value = "添加考试发布记录")
    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<ExamPublishRecordAddDTO> request) {
        return CommonResponseUtil.ok(examPublishRecordService.insert(request.getBody()));
    }

    /**
     * 查询考试发布记录
     * @param request 请求报文对象，传递dto
     * @return
     */
    @ApiLog(msg = "查询考试发布记录")
    @PostMapping("/records")
    @ApiOperation(value = "查询考试发布记录")
    public CommonResponse<CommonPage<ExamPublishRecordVO>> findAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<ExamPublishRecordQuery>> request){
        // 设置分页区间 index size
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(), request.getBody().getPageSize(), request.getBody().getOrderBy());
        List<ExamPublishRecordDTO> recordDTOS = examPublishRecordService.selectByPage(request.getBody().getQuery());
        // 转换为vo
        List<ExamPublishRecordVO> examPublishRecordVOS = PojoUtils.copyListProperties(recordDTOS, ExamPublishRecordVO::new);

        return buildPageResponse(page,examPublishRecordVOS);
    }


    /**
     * 批量删除数据
     *
     * @param request 请求报文对象，body为dto
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @ApiLog(msg = "删除考试发布记录")
    @ApiOperation(value = "删除考试发布记录")
    @Override
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<ExamPublishDeleteDTO>> request) {
        return CommonResponseUtil.ok(this.examPublishRecordService.delete(request.getBody()));
    }

    /**
     * 更新考试发布记录
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:10
     */
    @ApiLog(msg = "查询考试发布记录")
    @ApiOperation(value = "更新考试发布记录")
    @Override
    public CommonResponse<Integer> update(@Valid @RequestBody CommonRequest<ExamPublishRecordUpdateDTO> request) {
        log.info("test update");
        return CommonResponseUtil.ok(this.examPublishRecordService.update(request.getBody()));
    }

    /**
     * 发布考试
     *
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Boolean>
     * @author ChenTong
     * @date 2020/7/7 22:18
     */
    @ApiOperation(value = "发布考试")
    @Override
    public CommonResponse<Boolean> publishExam(CommonRequest<ExamPublishDTO> request) {
        return CommonResponseUtil.ok(this.examPublishRecordService.publishExam(request.getBody()));
    }

    /**
     * 发布考试
     *
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Boolean>
     * @author ChenTong
     * @date 2020/7/7 22:22
     */
    @Override
    @ApiOperation(value = "批量发布考试")
    public CommonResponse<Boolean> publishExamBatch(CommonRequest<List<ExamPublishDTO>> request) {
        return CommonResponseUtil.ok(this.examPublishRecordService.publishExamBatch(request.getBody()));
    }


}
