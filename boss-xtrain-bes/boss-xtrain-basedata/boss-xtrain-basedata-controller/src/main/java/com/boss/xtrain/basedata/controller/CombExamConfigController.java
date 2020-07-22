package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.CombExamConfigApi;
import com.boss.xtrain.basedata.pojo.dto.paper.CombConfigQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.paper.CombConfigVO;
import com.boss.xtrain.basedata.pojo.dto.paper.ConfigItemListDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.*;
import com.boss.xtrain.basedata.pojo.dto.paper.CombConfigItemQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.paper.CombConfigItemVO;
import com.boss.xtrain.basedata.pojo.dto.paper.ConfigItemDTO;
import com.boss.xtrain.basedata.pojo.vo.combexamconfig.*;
import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemQueryVO;
import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemVO;
import com.boss.xtrain.basedata.service.CombExamConfigService;
import com.boss.xtrain.basedata.service.SubjectService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.*;
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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class CombExamConfigController extends BaseController implements CombExamConfigApi {

    @Autowired
    private CombExamConfigService combExamConfigService;

    @Autowired
    private SubjectService subjectService;


    @Override
    @ApiLog(msg = "查询组卷配置（分页）")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    public CommonResponse<CommonPage<CombExamConfigVO>> queryExamConfig(@RequestBody CommonRequest<CommonPageRequest<CombExamConfigQueryVO>> commonRequest) {
        CombExamConfigQueryVO combExamConfigQueryVO = commonRequest.getBody().getQuery();
        Page<Object> objects = this.doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
        CombExamConfigQueryDTO combExamConfigQueryDTO = new CombExamConfigQueryDTO();
        PojoUtils.copyProperties(combExamConfigQueryVO,combExamConfigQueryDTO);
        List<CombExamConfigDTO> combExamConfigDTOS = combExamConfigService.queryConfig(combExamConfigQueryDTO);
        List<CombExamConfigVO> combExamConfigVOS = PojoUtils.copyListProperties(combExamConfigDTOS,CombExamConfigVO::new);
        return buildPageResponse(objects,combExamConfigVOS);
    }

    @Override
    @ApiLog(msg = "通过组卷id查询组卷明细")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    public CommonResponse<List<CombExamItemVO>> queryExamItemById(@RequestBody CommonRequest<CombExamItemQueryVO> commonRequest) {
        CombExamItemQueryDTO configItemQueryDto = new CombExamItemQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),configItemQueryDto);
        log.info(configItemQueryDto.toString());
        List<CombExamItemDTO> configItemDtoList = combExamConfigService.queryItem(configItemQueryDto);
        List<CombExamItemVO> configItemVos = PojoUtils.copyListProperties(configItemDtoList,CombExamItemVO::new);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),configItemVos);

    }

    @Override
    @ApiLog(msg = "删除组卷")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    public CommonResponse<Boolean> deleteExamConfig(@RequestBody CommonRequest<CombExamConfigDeleteVO> commonRequest) {
        CombExamConfigDeleteDTO combExamConfigDelDto = new CombExamConfigDeleteDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),combExamConfigDelDto);
        combExamConfigService.deleteConfig(combExamConfigDelDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ApiLog(msg = "批量删除组卷")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    public CommonResponse<Boolean> deleteExamConfigs(@RequestBody CommonRequest<CombExamConfigDeleteIdsVO> commonRequest) {
        CombExamConfigDeleteIdsDTO combExamConfigDeleteIdsDTO = new CombExamConfigDeleteIdsDTO();
        List<CombExamConfigDeleteDTO> combExamConfigDeleteDTOS = PojoUtils.copyListProperties(commonRequest.getBody().getDeleteList(),CombExamConfigDeleteDTO::new);
        combExamConfigDeleteIdsDTO.setDeleteList(combExamConfigDeleteDTOS);
        combExamConfigService.deleteConfigs(combExamConfigDeleteIdsDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ApiLog(msg = "插入组卷")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    public CommonResponse<CombExamConfigVO> insertExamConfig(@RequestBody @Valid CommonRequest<CombExamConfigVO> commonRequest) {
        CombExamConfigVO combExamConfigVO = commonRequest.getBody();
        CombExamConfigDTO combExamConfigDto = new CombExamConfigDTO();
        PojoUtils.copyProperties(combExamConfigVO,combExamConfigDto);
        List<CombExamItemDTO> combExamItemDTOS = PojoUtils.copyListProperties(commonRequest.getBody().getItemList(),CombExamItemDTO::new);
        combExamConfigDto.setCombExamItems(combExamItemDTOS);
        combExamConfigService.insertConfig(combExamConfigDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),combExamConfigVO);

    }

    @Override
    @ApiLog(msg = "更新组卷")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    public CommonResponse<CombExamConfigUpdateVO> updateExamConfig(@RequestBody CommonRequest<CombExamConfigUpdateVO> commonRequest) {
        CombExamConfigUpdateVO combExamConfigUpdateVO = commonRequest.getBody();
        CombExamConfigUpdateDTO combExamConfigUpdateDTO = new CombExamConfigUpdateDTO();
        PojoUtils.copyProperties(combExamConfigUpdateVO,combExamConfigUpdateDTO);
        log.info(combExamConfigUpdateDTO.toString());
        List<CombExamItemDTO> combExamItemDTOS =  PojoUtils.copyListProperties(commonRequest.getBody().getItemList(),CombExamItemDTO::new);
        combExamConfigUpdateDTO.setItemList(combExamItemDTOS);
        combExamConfigService.updateConfig(combExamConfigUpdateDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),combExamConfigUpdateVO);

    }

    @Override
    @ApiLog(msg = "插入组卷明细")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    public CommonResponse<List<CombExamItemVO>> insertExamItem(@RequestBody CommonRequest<List<CombExamItemVO>> commonRequest) {
        List<CombExamItemDTO> itemList = PojoUtils.copyListProperties(commonRequest.getBody(),CombExamItemDTO::new);
        log.info(itemList.toString());
        combExamConfigService.insertItem(itemList);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    @ApiLog(msg = "查询题目数量")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    public CommonResponse<Integer> querySubjectCount(@RequestBody CommonRequest<CombExamItemVO> commonRequest) {
        CombExamItemDTO configItemDto = new CombExamItemDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),configItemDto);
        Integer i = subjectService.querySubjectCount(configItemDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),i);

    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('comb_exam_admin')")
    @ApiLog(msg = "获取所有组卷配置")
    @ResponseBody
    public PageInfo<CombConfigVO> queryCombExamConfiguration(@RequestBody CombConfigQueryDTO combConfigQueryDTO) {
        CombExamConfigQueryDTO combExamConfigQueryDTO = new CombExamConfigQueryDTO();
        PojoUtils.copyProperties(combConfigQueryDTO,combExamConfigQueryDTO);
        log.info(combExamConfigQueryDTO.toString());
        Page<Object> objects = this.doBeforePagination(combConfigQueryDTO.getPageNum(),combConfigQueryDTO.getPageSize(),null);
        List<CombExamConfigDTO> combExamConfigDtoList = combExamConfigService.queryConfig(combExamConfigQueryDTO);
        List<CombConfigVO> combConfigVOS = new ArrayList<>();
        for (CombExamConfigDTO combExamConfigDTO:
             combExamConfigDtoList) {
            CombConfigVO combConfigVO = new CombConfigVO();
            combConfigVO.setId(combExamConfigDTO.getId());
            combConfigVO.setName(combExamConfigDTO.getName());
            combConfigVO.setCombExamConfigId(String.valueOf(combExamConfigDTO.getId()));
            combConfigVOS.add(combConfigVO);
        }
        log.info(combConfigVOS.toString());
        PageInfo<CombConfigVO> pageInfo = new PageInfo<>(combConfigVOS);
        pageInfo.setTotal(objects.getTotal());

        return pageInfo;
    }

    @Override
    @ApiLog(msg = "获取配置详情")
    @ResponseBody
    public List<CombConfigItemVO> queryCombExamConfigItem(@RequestBody CombConfigItemQueryDTO combConfigItemQueryDTO) {
        CombExamItemQueryDTO combExamItemQueryDTO = new CombExamItemQueryDTO();
        // PojoUtils.copyProperties(combConfigItemQueryDTO,combExamItemQueryDTO);
        combExamItemQueryDTO.setId(combConfigItemQueryDTO.getConfigId());
        combExamItemQueryDTO.setOrgId(1L);
        System.out.println(combExamItemQueryDTO.getId());
        List<CombExamItemDTO> combExamItemDTOS = combExamConfigService.queryItem(combExamItemQueryDTO);
        return PojoUtils.copyListProperties(combExamItemDTOS,CombConfigItemVO::new);

    }

    @Override
    @ApiLog(msg = "保存组卷明细")
    @ResponseBody
    public boolean saveCombItemList( @RequestBody ConfigItemListDTO configItemListDTO) {
        int count = 0;
        List<ConfigItemDTO> itemList = configItemListDTO.getItemList();
        log.info(itemList.toString());
        List<CombExamItemDTO> itemDTOS = PojoUtils.copyListProperties(itemList,CombExamItemDTO::new);
        for (CombExamItemDTO combExamItemDTO : itemDTOS){
            combExamItemDTO.setCombExamConfigId(itemList.get(count).getConfigExamConfigId());
            count++;
        }
        log.info(itemDTOS.toString());
        return combExamConfigService.insertItem(itemDTOS);
    }

}
