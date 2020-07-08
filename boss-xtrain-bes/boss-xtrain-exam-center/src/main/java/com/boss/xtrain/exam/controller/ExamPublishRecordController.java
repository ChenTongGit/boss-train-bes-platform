package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.exam.api.ExamPublishRecordApi;
import com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO;
import com.boss.xtrain.exam.service.ExamPublishRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@RequestMapping(CommonConstant.BASIC_URL+"/exampublishrecord")
public class ExamPublishRecordController extends BaseController implements ExamPublishRecordApi {

    @Resource
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
        return CommonResponseUtil.ok(examPublishRecordService.insert(request.getBody().get("exampublish")));
    }

    /**
     * 查询数据 返回数据vo列表
     *
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
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonRequest<V>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonRequest<ExamPublishRecordVO> select(@Valid CommonRequest<ExamPublishRecordQuery> request) {
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
     * @param examPublishRecordDTOs 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<Integer> deletePatch(@Valid CommonRequest<List<ExamPublishRecordDTO>> examPublishRecordDTOs) {
        return null;
    }

    /**
     * 更新数据
     *
     * @param examPublishRecordDTO
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:10
     */
    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<ExamPublishRecordDTO> examPublishRecordDTO) {
        return null;
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
