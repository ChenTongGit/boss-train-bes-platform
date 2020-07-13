package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.CombExamConfigApi;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.*;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.basedata.pojo.vo.combexamconfig.*;
import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemQueryVO;
import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeQueryVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeVO;
import com.boss.xtrain.basedata.service.CombExamConfigService;
import com.boss.xtrain.basedata.service.SubjectService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.util.PojoUtils;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CombExamConfigController extends BaseController implements CombExamConfigApi {

    @Autowired
    private CombExamConfigService combExamConfigService;

    @Autowired
    private SubjectService subjectService;


    @Override
    public CommonResponse<CommonPage<CombExamConfigVO>> queryExamConfig(@RequestBody CommonRequest<CombExamConfigQueryVO> commonRequest) {
        CombExamConfigQueryVO combExamConfigQueryVO = commonRequest.getBody();
        doBeforePagination(combExamConfigQueryVO.getPageIndex(),combExamConfigQueryVO.getPageSize(),combExamConfigQueryVO.getOrderBy());
        CombExamConfigQueryDTO combExamConfigQueryDTO = new CombExamConfigQueryDTO();
        PojoUtils.copyProperties(combExamConfigQueryVO,combExamConfigQueryDTO);
        List<CombExamConfigDTO> combExamConfigDTOS = combExamConfigService.queryConfig(combExamConfigQueryDTO);
        List<CombExamConfigVO> combExamConfigVOS = PojoUtils.copyListProperties(combExamConfigDTOS,CombExamConfigVO::new);
        PageInfo<CombExamConfigVO> pageInfo = new PageInfo<>(combExamConfigVOS);
        return buildPageResponse(pageInfo);
    }

    @Override
    public CommonResponse<List<CombExamItemVO>> queryExamItemById(@RequestBody CommonRequest<CombExamItemQueryVO> commonRequest) {
        CombExamItemQueryDTO configItemQueryDto = new CombExamItemQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),configItemQueryDto);
        List<CombExamItemDTO> configItemDtoList = combExamConfigService.queryItem(configItemQueryDto);
        List<CombExamItemVO> configItemVos = new ArrayList<>();
        PojoUtils.copyProperties(configItemDtoList,configItemVos);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    public CommonResponse<Boolean> deleteExamConfig(@RequestBody CommonRequest<CombExamConfigDeleteVO> commonRequest) {
        CombExamConfigDeleteDTO combExamConfigDelDto = new CombExamConfigDeleteDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),combExamConfigDelDto);
        combExamConfigService.deleteConfig(combExamConfigDelDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    public CommonResponse<CombExamConfigVO> insertExamConfig(@RequestBody CommonRequest<CombExamConfigVO> commonRequest) {
        CombExamConfigVO combExamConfigVO = commonRequest.getBody();
        CombExamConfigDTO combExamConfigDto = new CombExamConfigDTO();
        PojoUtils.copyProperties(combExamConfigVO,combExamConfigDto);
        List<CombExamItemVO> combExamItemVOS = PojoUtils.copyListProperties(commonRequest.getBody().getCombExamItems(),CombExamItemVO::new);
        combExamConfigDto.setCombExamItems(combExamItemVOS);
        List<CombExamItemDTO> combExamItemDTOS = PojoUtils.copyListProperties(combExamItemVOS,CombExamItemDTO::new);
        combExamConfigService.insertItem(combExamItemDTOS);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    public CommonResponse<CombExamConfigUpdateVO> updateSubjectType(@RequestBody CommonRequest<CombExamConfigUpdateVO> commonRequest) {
        CombExamConfigUpdateVO combExamConfigUpdateVO = commonRequest.getBody();
        CombExamConfigUpdateDTO combExamConfigUpdateDTO = new CombExamConfigUpdateDTO();
        PojoUtils.copyProperties(combExamConfigUpdateVO,combExamConfigUpdateDTO);
        List<CombExamItemDTO> combExamItemDTOS =  PojoUtils.copyListProperties(commonRequest.getBody().getCombExamItems(),CombExamItemDTO::new);
        combExamConfigUpdateDTO.setItemList(combExamItemDTOS);
        combExamConfigService.updateConfig(combExamConfigUpdateDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    public CommonResponse<List<CombExamItemVO>> insertExamItem(@RequestBody CommonRequest<List<CombExamItemVO>> commonRequest) {
        List<CombExamItemDTO> itemList = PojoUtils.copyListProperties(commonRequest.getBody(),CombExamItemDTO::new);
        combExamConfigService.insertItem(itemList);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    public CommonResponse<Integer> querySubjectCount(@RequestBody CommonRequest<CombExamItemVO> commonRequest) {
        CombExamItemDTO configItemDto = new CombExamItemDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),configItemDto);
        subjectService.querySubjectByConfig(configItemDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    public List<CombExamItemVO> queryConfigItem(@RequestBody CombExamItemQueryDTO configItemQueryDto) {
        List<CombExamItemDTO> configItemDtoList = combExamConfigService.queryItem(configItemQueryDto);
        List<CombExamItemVO> combExamItemVOS = new ArrayList<>();
        PojoUtils.copyProperties(configItemDtoList,combExamItemVOS);
        return combExamItemVOS;
    }
}
