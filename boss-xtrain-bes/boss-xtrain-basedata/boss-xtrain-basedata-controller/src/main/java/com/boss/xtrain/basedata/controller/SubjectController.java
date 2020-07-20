package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.SubjectApi;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.basedata.pojo.vo.subject.*;
import com.boss.xtrain.basedata.service.CombExamConfigService;
import com.boss.xtrain.basedata.service.SubjectService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SubjectController extends BaseController implements SubjectApi {

    @Resource
    private SubjectService subjectService;

    @Resource
    private CombExamConfigService combExamConfigService;

    @Override
    @ApiLog(msg = "查询题目(分页)")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<CommonPage<SubjectVO>> querySubjectPage(@RequestBody CommonRequest<SubjectQueryVO> commonRequest) {
        SubjectQueryVO subjectQuery = commonRequest.getBody();
        log.info(subjectQuery.toString());
        Page<Object> objects = doBeforePagination(subjectQuery.getPageNum(),subjectQuery.getPageSize(),null);
        SubjectQueryDTO subjectQueryDTO = new SubjectQueryDTO();
        PojoUtils.copyProperties(subjectQuery,subjectQueryDTO);
        List<SubjectDTO> subjectDTOS = subjectService.querySubjectByCondition(subjectQueryDTO);
        List<SubjectVO> subjectVOS = PojoUtils.copyListProperties(subjectDTOS,SubjectVO::new);
        PageInfo<SubjectVO> pageInfo = new PageInfo<>(subjectVOS);
        pageInfo.setTotal(objects.getTotal());
        return buildPageResponse(pageInfo,subjectVOS);
    }

    @Override
    @ApiLog(msg = "查询题目(不分页)")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<List<SubjectVO>> querySubjectList(@RequestBody CommonRequest<SubjectQueryVO> commonRequest) {
        SubjectQueryDTO subjectQueryDTO = new SubjectQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectQueryDTO);
        List<SubjectDTO> subjectListDto = subjectService.querySubjectByCondition(subjectQueryDTO);
        List<SubjectVO> subjectVOS = new ArrayList<>();
        PojoUtils.copyProperties(subjectListDto,subjectVOS);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectVOS);
    }

    @Override
    @ApiLog(msg = "删除题目")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<Boolean> deleteSubject(@RequestBody CommonRequest<SubjectDeleteVO> commonRequest) {
        SubjectDeleteDTO subjectDeleteDTO = new SubjectDeleteDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectDeleteDTO);
        subjectService.deleteSubject(subjectDeleteDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ApiLog(msg = "批量删除题目")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<Boolean> deleteSubjectList(@RequestBody CommonRequest<SubjectDeleteIdsVO> commonRequest) {
        SubjectDeleteIdsDTO subjectDeleteIdsDTO = new SubjectDeleteIdsDTO();
        List<Long> deleteList = commonRequest.getBody().getIds();
        subjectDeleteIdsDTO.setIds(deleteList);
        subjectService.deleteSubjectList(subjectDeleteIdsDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);
    }

    @Override
    @ApiLog(msg = "插入题目")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<SubjectVO> insertSubject(@RequestBody CommonRequest<SubjectUpdateVO> commonRequest) {
        SubjectUpdateDTO subjectUpdateDTO = new SubjectUpdateDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectUpdateDTO);
        log.info(subjectUpdateDTO.toString());
        List<SubjectAnswer> answerList = subjectUpdateDTO.getSubjectAnswers();
        subjectUpdateDTO.setSubjectAnswers(answerList);
        subjectService.insertSubject(subjectUpdateDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    @ApiLog(msg = "更新题目")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<SubjectVO> updateSubject(@RequestBody CommonRequest<SubjectUpdateVO> commonRequest) {
        SubjectUpdateDTO subjectUpdateDTO = new SubjectUpdateDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectUpdateDTO);
        log.info(subjectUpdateDTO.toString());
        List<SubjectAnswer> answerList = subjectUpdateDTO.getSubjectAnswers();
        subjectUpdateDTO.setSubjectAnswers(answerList);
        subjectService.updateSubject(subjectUpdateDTO);
        return  CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }

    @Override
    @ApiLog(msg = "获取题目答案")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<List<SubjectAnswerVO>> queryAnswer(@RequestBody CommonRequest<SubjectAnswerQueryVO> commonRequest) {
        SubjectAnswerQueryDTO answerQueryDTO = new SubjectAnswerQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),answerQueryDTO);
        log.info(answerQueryDTO.toString());
        List<SubjectAnswerDTO> subjectAnswerDTOS = subjectService.queryAnswer(answerQueryDTO);
        log.info(subjectAnswerDTOS.toString());
        List<SubjectAnswerDTO> subjectAnswerDTOList = subjectService.querySubjectOtherInfo(answerQueryDTO);
        log.info(subjectAnswerDTOList.toString());
        List<SubjectAnswerVO> subjectAnswerVOS = PojoUtils.copyListProperties(subjectAnswerDTOS,SubjectAnswerVO::new);
        log.info(subjectAnswerVOS.toString());
        subjectAnswerVOS = PojoUtils.copyListProperties(subjectAnswerDTOList,SubjectAnswerVO::new);
        log.info(subjectAnswerVOS.toString());
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectAnswerVOS);
    }

    @Override
    @ApiLog(msg = "获取题目难度")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<List<DifficultVO>> queryDifficult(@RequestBody CommonRequest<DifficultQueryVO> commonRequest) {
        DifficultQueryDTO difficultQueryDTO = new DifficultQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),difficultQueryDTO);
        List<DifficultDTO> difficultDTOS = subjectService.queryDifficult(difficultQueryDTO);
        List<DifficultVO> difficultVOS = PojoUtils.copyListProperties(difficultDTOS,DifficultVO::new);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),difficultVOS);
    }

    @Override
    @ApiLog(msg = "批量插入题目")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<SubjectVO> insertSubjectList(@RequestBody CommonRequest<List<SubjectUpdateVO>> commonRequest) {
        List<SubjectUpdateDTO> subjectUpdateDTOS = new ArrayList<>();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectUpdateDTOS);
        for(SubjectUpdateDTO s : subjectUpdateDTOS){
            List<SubjectAnswer> answers = s.getSubjectAnswers();
            s.setSubjectAnswers(answers);
        }
        subjectService.insertSubjectList(subjectUpdateDTOS);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }


}
