package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.SubjectApi;
import com.boss.xtrain.basedata.pojo.vo.paper.CombSubjectListVO;
import com.boss.xtrain.basedata.pojo.dto.paper.ConfigItemListDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.ConfigItemDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.CreatePaperDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.StandardCombDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.basedata.pojo.vo.subject.*;
import com.boss.xtrain.basedata.service.CombExamConfigService;
import com.boss.xtrain.basedata.service.SubjectService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
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
    public CommonResponse<CommonPage<SubjectVO>> querySubjectPage(@RequestBody CommonRequest<CommonPageRequest<SubjectQueryVO>> commonRequest) {
        SubjectQueryVO subjectQuery = commonRequest.getBody().getQuery();
        log.info(subjectQuery.toString());
        SubjectQueryDTO subjectQueryDTO = new SubjectQueryDTO();
        PojoUtils.copyProperties(subjectQuery,subjectQueryDTO);
        Page<Object> objects = this.doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
        List<SubjectDTO> subjectDTOS = subjectService.querySubjectByCondition(subjectQueryDTO);
        List<SubjectVO> subjectVOS = PojoUtils.copyListProperties(subjectDTOS,SubjectVO::new);
        return buildPageResponse(objects,subjectVOS);
    }

    @Override
    @ApiLog(msg = "查询题目(不分页)")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_admin')")
    public CommonResponse<List<SubjectVO>> querySubjectList(@RequestBody CommonRequest<SubjectQueryVO> commonRequest) {
        SubjectQueryDTO subjectQueryDTO = new SubjectQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectQueryDTO);
        List<SubjectDTO> subjectListDto = subjectService.querySubjectByCondition(subjectQueryDTO);
        List<SubjectVO> subjectVOS = PojoUtils.copyListProperties(subjectListDto,SubjectVO::new);
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
        List<SubjectDeleteDTO> deleteList = PojoUtils.copyListProperties(commonRequest.getBody().getIds(),SubjectDeleteDTO::new);
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
        log.info("插入{}",subjectUpdateDTO.toString());
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
        List<SubjectAnswerDTO> subjectAnswerDTOS = subjectService.queryAnswer(answerQueryDTO);
        List<SubjectAnswerDTO> subjectAnswerDTOList = subjectService.querySubjectOtherInfo(answerQueryDTO);
        List<SubjectAnswerVO> subjectAnswerVOS = PojoUtils.copyListProperties(subjectAnswerDTOS,SubjectAnswerVO::new);
        subjectAnswerVOS = PojoUtils.copyListProperties(subjectAnswerDTOList,SubjectAnswerVO::new);
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
        List<SubjectUpdateDTO> subjectUpdateDTOS = PojoUtils.copyListProperties(commonRequest.getBody(),SubjectUpdateDTO::new);
        log.info(commonRequest.getBody().toString());
        for(SubjectUpdateDTO s : subjectUpdateDTOS){
            List<SubjectAnswer> answers = s.getSubjectAnswers();
            s.setSubjectAnswers(answers);
        }
        log.info(subjectUpdateDTOS.toString());
        subjectService.insertSubjectList(subjectUpdateDTOS);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }


    @Override
    @ApiLog(msg = "标准组卷")
    @ResponseBody
    public List<CombSubjectListVO> standardCombExam(@RequestBody StandardCombDTO standardCombDTO) {
        List<SubjectDTO> subjectDTOS = subjectService.querySubjectByConfig(standardCombDTO);
        return PojoUtils.copyListProperties(subjectDTOS,CombSubjectListVO::new);

    }

    @Override
    @ApiLog(msg = "快速组卷")
    @ResponseBody
    public List<CombSubjectListVO> addPaper(@RequestBody CreatePaperDTO createPaperDTO) {
        CombExamItemQueryDTO combExamItemQueryDTO = new CombExamItemQueryDTO();
        PojoUtils.copyProperties(createPaperDTO,combExamItemQueryDTO);
        log.info(combExamItemQueryDTO.toString());
        List<CombExamItemDTO> combExamItemDTOS = combExamConfigService.queryItem(combExamItemQueryDTO);
        log.info(combExamItemDTOS.toString());
        List<SubjectDTO> subjectDTOS = subjectService.querySubject(combExamItemDTOS);
        log.info(subjectDTOS.toString());
        return PojoUtils.copyListProperties(subjectDTOS,CombSubjectListVO::new);
    }

    @Override
    @ApiLog(msg = "自定义组卷")
    @ResponseBody
    public List<CombSubjectListVO> addPaperByConfigItems(@RequestBody ConfigItemListDTO configItemListDTO) {
        List<ConfigItemDTO> configItemDTOS = configItemListDTO.getItemList();
        List<CombExamItemDTO> combExamItemDTOS = PojoUtils.copyListProperties(configItemDTOS,CombExamItemDTO::new);
        List<SubjectDTO> subjectDTOS = subjectService.querySubject(combExamItemDTOS);
        return PojoUtils.copyListProperties(subjectDTOS,CombSubjectListVO::new);
    }

}
