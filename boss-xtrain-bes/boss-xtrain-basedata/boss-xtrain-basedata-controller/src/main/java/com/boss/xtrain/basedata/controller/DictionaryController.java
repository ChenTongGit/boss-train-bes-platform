package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.DictionaryApi;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.dictionary.*;
import com.boss.xtrain.basedata.service.DictionaryService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


/**
 * @author guo xinrui
 * @description 字典controller
 * @date 2020/07/08
 */
@RestController
@Slf4j
public class DictionaryController extends BaseController implements DictionaryApi {

    @Autowired
    private DictionaryService dictionaryService;


    @Override
    @ApiLog(msg = "新增字典")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<DictionaryVO> insertDictionary(@RequestBody @Valid CommonRequest<DictionaryInsertVO> commonRequest) {
        DictionaryDTO dictionaryDTO = new DictionaryDTO();
        DictionaryInsertVO dictionaryInsertVO = commonRequest.getBody();
        PojoUtils.copyProperties(dictionaryInsertVO,dictionaryDTO);
        dictionaryService.insertDictionary(dictionaryDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }

    @Override
    @ApiLog(msg = "批量插入字典信息")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<List<DictionaryVO>> insertDictionaryList(@RequestBody CommonRequest<List<DictionaryInsertVO>> commonRequest) {
        List<DictionaryDTO> dictionaryDTOS =PojoUtils.copyListProperties(commonRequest.getBody(), DictionaryDTO::new);
        dictionaryService.insertDictionaryList(dictionaryDTOS);
        List<DictionaryVO> dictionaryVOS = PojoUtils.copyListProperties(dictionaryDTOS,DictionaryVO::new);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),dictionaryVOS);

    }

    @Override
    @ApiLog(msg = "删除字典信息")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<Boolean> deleteDictionary(@RequestBody CommonRequest<DictionaryDeleteVO> commonRequest) {
        DictionaryDTO dictionaryDto = new DictionaryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(), dictionaryDto);
        dictionaryService.deleteDictionary(dictionaryDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ApiLog(msg = "批量删除字典")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<Boolean> deleteDictionaryByIds(@RequestBody CommonRequest<List<DictionaryDeleteVO>> commonRequest) {
        List<DictionaryDeleteVO> dictionaryDeleteVOS = commonRequest.getBody();
        List<DictionaryDTO> dictionaryDTOS  = PojoUtils.copyListProperties(dictionaryDeleteVOS, DictionaryDTO::new);
        dictionaryService.deleteDictionaryByIds(dictionaryDTOS);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ApiLog(msg = "更新字典")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<DictionaryVO> updateDictionary(@RequestBody CommonRequest<DictionaryUpdateVO> commonRequest) {
        DictionaryDTO dictionaryDto = new DictionaryDTO();
        DictionaryUpdateVO dictionaryVo = commonRequest.getBody();
        PojoUtils.copyProperties(dictionaryVo, dictionaryDto);
        dictionaryService.updateDictionary(dictionaryDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    @ApiLog(msg = "分页查询全部字典数据")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<CommonPage<DictionaryVO>> queryDictionary(@RequestBody CommonRequest<CommonPageRequest<DictionaryQueryVO>> commonRequest) {
        Page<Object> page=this.doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
        List<DictionaryDTO> dictionaryDTOS = dictionaryService.getDictionary();
        List<DictionaryVO> dictionaryVos = PojoUtils.copyListProperties(dictionaryDTOS, DictionaryVO::new);
        return buildPageResponse(page,dictionaryVos);

    }

    @Override
    @ApiLog(msg = "分页查询字典")
    @ResponseBody
    public CommonResponse<CommonPage<DictionaryVO>> queryDictionaryPage(@RequestBody CommonRequest<CommonPageRequest<DictionaryQueryVO>> commonRequest) {
        DictionaryQueryVO dictionaryQueryVO = commonRequest.getBody().getQuery();
        DictionaryQueryDTO dictionaryQueryDTO= new DictionaryQueryDTO();
        PojoUtils.copyProperties(dictionaryQueryVO,dictionaryQueryDTO);
        Page<Object> page=this.doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
        List<DictionaryDTO> dictionaryDTOList=dictionaryService.queryDictionary(dictionaryQueryDTO);
        List<DictionaryVO> dictionaryVOS=PojoUtils.copyListProperties(dictionaryDTOList,DictionaryVO::new);
        return buildPageResponse(page,dictionaryVOS);
    }

    @Override
    @ApiLog(msg = "根据orgId获取category")
    @ResponseBody
    public CommonResponse<List<DifficultQueryDTO>> queryCategory() {
        DifficultQueryDTO difficultQueryDTO = new DifficultQueryDTO();
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(), dictionaryService.queryCategory(difficultQueryDTO));
    }


    @Override
    @ApiLog(msg = "获取字典类型列表")
    @ResponseBody
    public CommonResponse<List<DictionaryVO>> queryCategoryList(@RequestBody CommonRequest<DictionaryVO> commonRequest) {
        DictionaryDTO dictionaryDTO =new DictionaryDTO();
        List<DictionaryDTO> dictionaryDTOS = dictionaryService.selectList(dictionaryDTO);
        List<DictionaryVO> dictionaryVOS =PojoUtils.copyListProperties(dictionaryDTOS,DictionaryVO::new);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),dictionaryVOS);
    }
}
