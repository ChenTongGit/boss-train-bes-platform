package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.redis.api.RedisUtil;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.api.ExamPublishRecordApi;
import com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamPublishRecord;
import com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO;
import com.boss.xtrain.exam.service.ExamPublishRecordService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
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
    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<ExamPublishRecordDTO> request) {
        return CommonResponseUtil.ok(examPublishRecordService.insert(request.getBody()));
    }

    /**
     * 查询考试发布记录
     * @param request
     * @return
     */
    @ApiLog(msg = "查询考试发布记录")
    @PostMapping("/records")
    @ApiOperation(value = "查询考试发布记录")
    public CommonResponse<CommonPage<ExamPublishRecordVO>> findAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<ExamPublishRecordQuery>> request){
        List<ExamPublishRecordDTO> examPublishRecordDTOS ;
        ExamPublishRecordQuery query = request.getBody().getQuery();
        // 设置分页区间
        doBeforePagination(request.getBody().getPageNum(), request.getBody().getPageSize());
        // 读取数据
        if (query == null){
            examPublishRecordDTOS  = examPublishRecordService.selectAll();
        }else {
            examPublishRecordDTOS = examPublishRecordService.selectByCondition(query);
        }
        // 转换为vo
        List<ExamPublishRecordVO> examPublishRecordVOS = new ArrayList<>();
        for (ExamPublishRecordDTO item: examPublishRecordDTOS
             ) {
            ExamPublishRecordVO examPublishRecordVO = new ExamPublishRecordVO();
            PojoUtils.copyProperties(item, examPublishRecordVO);
            examPublishRecordVOS.add(examPublishRecordVO);
        }
        // 返回分页信息
        return buildPageResponse(new PageInfo<>(examPublishRecordVOS));
    }


    /**
     * 查询数据 返回数据vo列表
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.util.List < V>>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<List<ExamPublishRecordVO>> selectList(@Valid CommonRequest<ExamPublishRecordQuery> request) {
        return null;
    }



    /**
     * 查找指定查询条件的数据
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonRequest<V>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<ExamPublishRecordVO> select(@Valid CommonRequest<ExamPublishRecordQuery> request) {
        return null;
    }


    /**
     * 指定删除某个数据数据
     * @param examPublishRecordDTO 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<ExamPublishRecordDTO> examPublishRecordDTO) {
        return null;
    }

    /**
     * 批量删除数据
     *
     * @param request 请求报文对象，body为dto
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @ApiOperation(value = "删除考试发布记录")
    @Override
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<ExamPublishRecordDTO>> request) {
        return CommonResponseUtil.ok(this.examPublishRecordService.delete(request.getBody()));
    }

    /**
     * 更新考试发布记录
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:10
     */
    @ApiOperation(value = "更新考试发布记录")
    @Override
    public CommonResponse<Integer> update(@Valid @RequestBody CommonRequest<ExamPublishRecordDTO> request) {
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
    @Override
    public CommonResponse<Boolean> publishExam(CommonRequest<ExamPublishRecordDTO> request) {
        return null;
    }
}
