package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.SubjectTypeApi;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.subject.SubjectDeleteVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeDeleteIdsVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeQueryVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeVO;
import com.boss.xtrain.basedata.service.SubjectTypeService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class SubjectTypeController extends BaseController implements SubjectTypeApi {

    @Resource
    private SubjectTypeService subjectTypeService;

    @Override
    @ApiLog(msg = "新增题型")
    @ResponseBody
    public CommonResponse<SubjectTypeVO> insertSubjectType(@RequestBody @Valid CommonRequest<SubjectTypeVO> commonRequest) {
        SubjectTypeVO subjectTypeVO = commonRequest.getBody();
        SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
        PojoUtils.copyProperties(subjectTypeVO,subjectTypeDTO);
        subjectTypeService.insertSubjectType(subjectTypeDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectTypeVO);
    }

    @Override
    @ApiLog(msg = "删除题型")
    @ResponseBody
    public CommonResponse<Boolean> deleteSubjectType(@RequestBody CommonRequest<SubjectDeleteVO> commonRequest) {
        SubjectTypeDeleteDTO subjectTypeDelDto = new SubjectTypeDeleteDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectTypeDelDto);
        subjectTypeService.deleteSubjectType(subjectTypeDelDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ApiLog(msg = "批量删除题型")
    @ResponseBody
    public CommonResponse<Boolean> deleteSubjectTypeList(@RequestBody CommonRequest<SubjectTypeDeleteIdsVO> commonRequest) {
        SubjectTypeDeleteIdsVO subjectTypeDeleteIdsVO = commonRequest.getBody();
        SubjectTypeDeleteIdsDTO subjectTypeDeleteIdsDTO = new SubjectTypeDeleteIdsDTO();
        PojoUtils.copyProperties(subjectTypeDeleteIdsVO,subjectTypeDeleteIdsDTO);
        subjectTypeService.deleteSubjectTypes(subjectTypeDeleteIdsDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);
    }

    @Override
    @ResponseBody
    public CommonResponse<SubjectTypeVO> updateSubjectType(@RequestBody @Valid CommonRequest<SubjectTypeVO> commonRequest) {
        SubjectTypeVO subjectTypeVO = commonRequest.getBody();
        SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
        PojoUtils.copyProperties(subjectTypeVO,subjectTypeDTO);
        subjectTypeService.updateSubjectType(subjectTypeDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectTypeVO);
    }

    @Override
    public CommonResponse<CommonPage<SubjectTypeVO>> querySubjectTypePage(@RequestBody @Valid CommonRequest<CommonPageRequest<SubjectTypeQueryVO>> commonRequest) {
        SubjectTypeQueryVO subjectTypeQueryVO = commonRequest.getBody().getQuery();
        if (subjectTypeQueryVO == null){
            List<SubjectTypeDTO> subjectTypeDTOS = subjectTypeService.queryAll();
            Page<Object> objects = this.doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
            List<SubjectTypeVO> subjectTypeVOS = PojoUtils.copyListProperties(subjectTypeDTOS,SubjectTypeVO::new);
            return buildPageResponse(objects,subjectTypeVOS);
        }else {
            Page<Object> objects = this.doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
            SubjectTypeQueryDTO subjectTypeQueryDTO = new SubjectTypeQueryDTO();
            PojoUtils.copyProperties(subjectTypeQueryVO,subjectTypeQueryDTO);
            log.info(subjectTypeQueryDTO.toString());
            List<SubjectTypeDTO> subjectTypeDTOS = subjectTypeService.querySubjectType(subjectTypeQueryDTO);
            log.info(subjectTypeDTOS.toString());
            List<SubjectTypeVO> subjectTypeVOS  = PojoUtils.copyListProperties(subjectTypeDTOS,SubjectTypeVO::new);
            return buildPageResponse(objects,subjectTypeVOS);
        }


    }


}
