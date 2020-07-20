package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.SubjectTypeApi;
import com.boss.xtrain.basedata.api.paper.CombInfoQueryDTO;
import com.boss.xtrain.basedata.api.paper.SubjectTypePaperVO;
import com.boss.xtrain.basedata.mapper.SubjectTypeMapper;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryQueryVO;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryVO;
import com.boss.xtrain.basedata.pojo.vo.subject.SubjectDeleteVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeDeleteIdsVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeDeleteVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeQueryVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeVO;
import com.boss.xtrain.basedata.service.SubjectTypeService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SubjectTypeController extends BaseController implements SubjectTypeApi {

    @Resource
    private SubjectTypeService subjectTypeService;

    @Override
    @ApiLog(msg = "新增题型")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_type_admin')")
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
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_type_admin')")
    public CommonResponse<Boolean> deleteSubjectType(@RequestBody CommonRequest<SubjectDeleteVO> commonRequest) {
        SubjectTypeDeleteDTO subjectTypeDelDto = new SubjectTypeDeleteDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectTypeDelDto);
        subjectTypeService.deleteSubjectType(subjectTypeDelDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ApiLog(msg = "批量删除题型")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_type_admin')")
    public CommonResponse<Boolean> deleteSubjectTypeList(@RequestBody CommonRequest<SubjectTypeDeleteIdsVO> commonRequest) {
        SubjectTypeDeleteIdsVO subjectTypeDeleteIdsVO = commonRequest.getBody();
        SubjectTypeDeleteIdsDTO subjectTypeDeleteIdsDTO = new SubjectTypeDeleteIdsDTO();
        PojoUtils.copyProperties(subjectTypeDeleteIdsVO,subjectTypeDeleteIdsDTO);
        subjectTypeService.deleteSubjectTypes(subjectTypeDeleteIdsDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);
    }

    @Override
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_type_admin')")
    public CommonResponse<SubjectTypeVO> updateSubjectType(@RequestBody @Valid CommonRequest<SubjectTypeVO> commonRequest) {
        SubjectTypeVO subjectTypeVO = commonRequest.getBody();
        SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
        PojoUtils.copyProperties(subjectTypeVO,subjectTypeDTO);
        subjectTypeService.updateSubjectType(subjectTypeDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectTypeVO);
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_type_admin')")
    public CommonResponse<CommonPage<SubjectTypeVO>> querySubjectTypePage(@RequestBody @Valid CommonRequest<SubjectTypeQueryVO> commonRequest) {
        SubjectTypeQueryVO subjectTypeQueryVO = commonRequest.getBody();
        if (subjectTypeQueryVO.getName() == "" || subjectTypeQueryVO.getName() == null){
            List<SubjectTypeDTO> subjectTypeDTOS = subjectTypeService.queryAll();
            Page<Object> objects = doBeforePagination(subjectTypeQueryVO.getPageNum(),subjectTypeQueryVO.getPageSize(),subjectTypeQueryVO.getName());
            List<SubjectTypeVO> subjectTypeVOS = PojoUtils.copyListProperties(subjectTypeDTOS,SubjectTypeVO::new);
            PageInfo<SubjectTypeVO> pageInfo = new PageInfo<>(subjectTypeVOS);
            pageInfo.setTotal(objects.getTotal());
            return buildPageResponse(pageInfo,subjectTypeVOS);
        }else {
            Page<Object> objects = doBeforePagination(subjectTypeQueryVO.getPageNum(),subjectTypeQueryVO.getPageSize(),null);
            SubjectTypeQueryDTO subjectTypeQueryDTO = new SubjectTypeQueryDTO();
            PojoUtils.copyProperties(subjectTypeQueryVO,subjectTypeQueryDTO);
            log.info(subjectTypeQueryDTO.toString());
            List<SubjectTypeDTO> subjectTypeDTOS = subjectTypeService.querySubjectType(subjectTypeQueryDTO);
            log.info(subjectTypeDTOS.toString());
            List<SubjectTypeVO> subjectTypeVOS  = PojoUtils.copyListProperties(subjectTypeDTOS,SubjectTypeVO::new);
            PageInfo<SubjectTypeVO> pageInfo = new PageInfo<>(subjectTypeVOS);
            pageInfo.setTotal(objects.getTotal());
            return buildPageResponse(pageInfo,subjectTypeVOS);
        }


    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('subject_type_admin')")
    public List<SubjectTypePaperVO> querySubjectType(@RequestBody @Valid CombInfoQueryDTO combInfoQueryDTO) {
        return null;
    }


}
