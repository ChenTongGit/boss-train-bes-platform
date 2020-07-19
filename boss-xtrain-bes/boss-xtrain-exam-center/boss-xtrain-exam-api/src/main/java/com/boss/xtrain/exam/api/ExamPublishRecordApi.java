package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.pojo.dto.*;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.vo.ExamPaperPreviewVO;
import com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
public interface ExamPublishRecordApi {

    /**
     * 更新考试发布记录
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:10
     */
    @PostMapping("/publishRecordChange")
    CommonResponse<Integer> update(@Valid @RequestBody CommonRequest<ExamPublishRecordUpdateDTO> request);
    
    /**
     * 发布考试
     * @author ChenTong
     * @param request 
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Boolean>
     * @date 2020/7/7 22:22
     */
    @PutMapping("/publishStatus")
    CommonResponse<Boolean> publishExam(@RequestBody @Valid CommonRequest<ExamPublishDTO> request);


    /**
     * 发布考试
     * @author ChenTong
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Boolean>
     * @date 2020/7/7 22:22
     */
    @PutMapping("/publishBatchStatus")
    CommonResponse<Boolean> publishExamBatch(@RequestBody @Valid CommonRequest<List<ExamPublishDTO>> request);

    /**
     * 批量删除数据
     *
     * @param request 请求报文对象，body为dto
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @DeleteMapping("/publishRecordDeletion")
    CommonResponse<Integer> deleteBatch(@RequestBody @Valid  CommonRequest<List<ExamPublishDeleteDTO>> request);

    /**
     * 添加新的数据
     * @param request 请求报文对象，传递dto
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @PostMapping("/newPublishRecord")
    CommonResponse<Integer> insert(@RequestBody @Valid  CommonRequest<ExamPublishRecordAddDTO> request);

    /**
     * 条件查询并分页
     * @author ChenTong
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.common.core.http.CommonPage<com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO>>
     * @date 2020/7/8 21:34
     */
    @PostMapping("/publishRecordList")
    CommonResponse<CommonPage<ExamPublishRecordVO>> findAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<ExamPublishRecordQuery>> request);

    /**
     * 获取考试预览
     * @author ChenTong
     * @param request 
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.exam.pojo.vo.ExamPaperPreviewVO>
     * @date 2020/7/18 19:37
     */
    @PostMapping("/paper")
    CommonResponse<ExamPaperPreviewVO> getPaperDetail(CommonRequest<ExamPaperQuery> request);
}
