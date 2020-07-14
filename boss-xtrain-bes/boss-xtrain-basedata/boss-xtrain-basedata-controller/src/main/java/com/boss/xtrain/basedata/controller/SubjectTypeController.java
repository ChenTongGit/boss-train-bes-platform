package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.SubjectTypeApi;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
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
import com.boss.xtrain.common.util.PojoUtils;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SubjectTypeController extends BaseController implements SubjectTypeApi {

    @Resource
    private SubjectTypeService subjectTypeService;

    @Override
    @ResponseBody
    public CommonResponse<SubjectTypeVO> insertSubjectType(@RequestBody CommonRequest<SubjectTypeVO> commonRequest) {
        SubjectTypeVO subjectTypeVO = commonRequest.getBody();
        SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
        PojoUtils.copyProperties(subjectTypeVO,subjectTypeDTO);
        subjectTypeService.insertSubjectType(subjectTypeDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectTypeVO);
    }

    @Override
    @ResponseBody
    public CommonResponse<Boolean> deleteSubjectType(@RequestBody CommonRequest<SubjectDeleteVO> commonRequest) {
        SubjectTypeDeleteDTO subjectTypeDelDto = new SubjectTypeDeleteDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),subjectTypeDelDto);
        subjectTypeService.deleteSubjectType(subjectTypeDelDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    public CommonResponse<Boolean> deleteSubjectTypeList(@RequestBody CommonRequest<List<SubjectTypeDeleteVO>> commonRequest) {
        List<SubjectTypeDeleteVO> subjectTypeDeleteVOS = commonRequest.getBody();
        List<SubjectTypeDeleteDTO> subjectTypeDeleteDTOS = PojoUtils.copyListProperties(subjectTypeDeleteVOS,SubjectTypeDeleteDTO::new);
        subjectTypeService.deleteSubjectTypes(subjectTypeDeleteDTOS);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);
    }

    @Override
    @ResponseBody
    public CommonResponse<SubjectTypeVO> updateSubjectType(@RequestBody CommonRequest<SubjectTypeVO> commonRequest) {
        SubjectTypeVO subjectTypeVO = commonRequest.getBody();
        SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
        PojoUtils.copyProperties(subjectTypeVO,subjectTypeDTO);
        subjectTypeService.updateSubjectType(subjectTypeDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),subjectTypeVO);
    }

    @Override
    public CommonResponse<CommonPage<SubjectTypeVO>> querySubjectTypePage(@RequestBody CommonRequest<SubjectTypeQueryVO> commonRequest) {
        SubjectTypeQueryVO subjectTypeQueryVO = commonRequest.getBody();
        log.info(subjectTypeQueryVO.toString());
        doBeforePagination(subjectTypeQueryVO.getPageIndex(),subjectTypeQueryVO.getPageSize(),subjectTypeQueryVO.getOrderBy());
        SubjectTypeQueryDTO subjectTypeQueryDTO = new SubjectTypeQueryDTO();
        PojoUtils.copyProperties(subjectTypeQueryVO,subjectTypeQueryDTO);
        List<SubjectTypeDTO> subjectTypeDTOS = subjectTypeService.querySubjectType(subjectTypeQueryDTO);
        List<SubjectTypeVO> subjectTypeVOS = new ArrayList<>();
        PojoUtils.copyProperties(subjectTypeDTOS,subjectTypeVOS);
        PageInfo<SubjectTypeVO> pageInfo = new PageInfo<>(subjectTypeVOS);
        return buildPageResponse(pageInfo);
    }

    @Override
    public List<SubjectTypeVO> querySubjectType(@RequestBody SubjectTypeQueryDTO subjectTypeQueryDTO) {
        List<SubjectTypeDTO> subjectTypeDTOS = subjectTypeService.querySubjectTypeById(subjectTypeQueryDTO.getOrgId());
        List<SubjectTypeVO> subjectTypeVOS = PojoUtils.copyListProperties(subjectTypeDTOS,SubjectTypeVO::new);
        return subjectTypeVOS;
    }
}
