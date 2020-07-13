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
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SubjectController implements SubjectApi {

    @Resource
    private SubjectService subjectService;

    @Resource
    private CombExamConfigService combExamConfigService;

    @Override
    @ResponseBody
    public CommonResponse<CommonPage<SubjectVO>> querySubject(@RequestBody CommonRequest<SubjectQuery> commonRequest) {
        return null;
    }

    @Override
    @ResponseBody
    public CommonResponse<List<SubjectVO>> querySubjectList(@RequestBody CommonRequest<SubjectQuery> commonRequest) {
        SubjectQueryDTO subjectQueryDTO = new SubjectQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectQueryDTO);
        List<SubjectDTO> subjectListDto = subjectService.querySubjectByCondition(subjectQueryDTO);
        List<SubjectVO> subjectVOS = new ArrayList<>();
        PojoUtils.copyProperties(subjectListDto,subjectVOS);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectVOS);
    }

    @Override
    @ResponseBody
    public CommonResponse<Boolean> deleteSubject(@RequestBody CommonRequest<SubjectDeleteVO> commonRequest) {
        SubjectDeleteDTO subjectDeleteDTO = new SubjectDeleteDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectDeleteDTO);
        subjectService.deleteSubject(subjectDeleteDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ResponseBody
    public CommonResponse<Boolean> deleteSubjectList(@RequestBody CommonRequest<SubjectDeleteIdsVO> commonRequest) {
        SubjectDeleteIdsDTO subjectDeleteIdsDTO = new SubjectDeleteIdsDTO();
        List<Long> deleteList = new ArrayList<>();
        PojoUtils.copyProperties(commonRequest.getBody().getIds(),deleteList);
        subjectDeleteIdsDTO.setIds(deleteList);
        subjectService.deleteSubjectList(subjectDeleteIdsDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);
    }

    @Override
    @ResponseBody
    public CommonResponse<SubjectVO> insertSubject(@RequestBody CommonRequest<SubjectUpdateVO> commonRequest) {
        SubjectUpdateDTO subjectUpdateDTO = new SubjectUpdateDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectUpdateDTO);
        List<SubjectAnswer> answerList = subjectUpdateDTO.getSubjectAnswers();
        subjectUpdateDTO.setSubjectAnswers(answerList);
        subjectService.insertSubject(subjectUpdateDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    @ResponseBody
    public CommonResponse<SubjectVO> updateSubject(@RequestBody CommonRequest<SubjectUpdateVO> commonRequest) {
        SubjectUpdateDTO subjectUpdateDTO = new SubjectUpdateDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectUpdateDTO);
        List<SubjectAnswer> answerList = subjectUpdateDTO.getSubjectAnswers();
        subjectUpdateDTO.setSubjectAnswers(answerList);
        subjectService.updateSubject(subjectUpdateDTO);
        return  CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }

    @Override
    @ResponseBody
    public CommonResponse<List<SubjectAnswerVO>> queryAnswer(@RequestBody CommonRequest<SubjectAnswerQueryVO> commonRequest) {
        SubjectAnswerQueryDTO answerQueryDto = new SubjectAnswerQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),answerQueryDto);
        List<SubjectAnswerDTO> subjectAnswerDtoList = subjectService.queryAnswer(answerQueryDto);
        List<SubjectAnswerVO> subjectAnswerVos = new ArrayList<>();
        PojoUtils.copyProperties(subjectAnswerDtoList,subjectAnswerVos);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectAnswerVos);
    }

    @Override
    @ResponseBody
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

    @Override
    @ResponseBody
    public SubjectExamVO querySubjectById(@RequestBody List<Long> subjectIds) {
        SubjectExamDTO examSubjectDto = subjectService.querySubjectById(subjectIds);
        SubjectExamVO examSubjectVo = new SubjectExamVO();
        PojoUtils.copyProperties(examSubjectDto,examSubjectVo);
        List<SubjectVO> subjectVos = new ArrayList<>();
        PojoUtils.copyProperties(examSubjectDto.getSubjectVOS(),subjectVos);
        examSubjectVo.setSubjectVOS(subjectVos);
        return examSubjectVo;

    }

    @Override
    @ResponseBody
    public List<SubjectVO> querySubject(@RequestBody SubjectQueryDTO subjectQueryDTO) {
        String subjectItemList = subjectQueryDTO.getSubjectName();
        return null;
    }

    @Override
    @ResponseBody
    public List<SubjectVO> querySubjectToPaper(@RequestBody CombExamItemQueryDTO configItemQueryDto) {
        List<CombExamItemDTO> combExamItemDTOS =  combExamConfigService.queryItem(configItemQueryDto);
        List<SubjectDTO> subjectDtoList = subjectService.querySubject(combExamItemDTOS);
        List<SubjectVO> subjectVOS = new ArrayList<>();
        PojoUtils.copyProperties(subjectDtoList,subjectDtoList);
        return subjectVOS;

    }

    @Override
    @ResponseBody
    public List<SubjectVO> querySubjectByConfig(@RequestBody CombExamItemDTO configItemsDto) {
        List<SubjectDTO> subjectDtoList = subjectService.querySubjectByConfig(configItemsDto);
        List<SubjectVO> subjectVOS = new ArrayList<>();
        PojoUtils.copyProperties(subjectDtoList,subjectVOS);
        return subjectVOS;
    }

}
