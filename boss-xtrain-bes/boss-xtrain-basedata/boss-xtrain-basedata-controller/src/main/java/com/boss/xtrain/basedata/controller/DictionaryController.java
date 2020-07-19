package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.DictionaryApi;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import com.boss.xtrain.basedata.pojo.vo.dictionary.*;
import com.boss.xtrain.basedata.service.DictionaryService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.list.AbstractLinkedList;
import org.bouncycastle.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DictionaryController extends BaseController implements DictionaryApi {

    @Autowired
    private DictionaryService dictionaryService;


    @Override
    @ApiLog(msg = "新增字典")
    @ResponseBody
    public CommonResponse<DictionaryVO> insertDictionary(@RequestBody @Validated CommonRequest<DictionaryInsertVO> commonRequest) {
        DictionaryDTO dictionaryDTO = new DictionaryDTO();
        DictionaryInsertVO dictionaryInsertVO = commonRequest.getBody();
        PojoUtils.copyProperties(dictionaryInsertVO,dictionaryDTO);
        log.info(commonRequest.getBody().toString());
        dictionaryService.insertDictionary(dictionaryDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }

    @Override
    @ResponseBody
    public CommonResponse<List<DictionaryVO>> insertDictionaryList(@RequestBody CommonRequest<List<DictionaryInsertVO>> commonRequest) {
        List<DictionaryDTO> dictionaryDTOS = new ArrayList<>();
        PojoUtils.copyProperties(commonRequest.getBody(), dictionaryDTOS);
        dictionaryService.insertDictionaryList(dictionaryDTOS);
        List<DictionaryVO> dictionaryVOS = new ArrayList<>();
        PojoUtils.copyProperties(dictionaryDTOS,dictionaryVOS);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),dictionaryVOS);

    }

    @Override
    @ResponseBody
    public CommonResponse<Boolean> deleteDictionary(@RequestBody CommonRequest<DictionaryDeleteVO> commonRequest) {
        DictionaryDTO dictionaryDto = new DictionaryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(), dictionaryDto);
        dictionaryService.insertDictionary(dictionaryDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ResponseBody
    public CommonResponse<Boolean> deleteDictionaryByIds(@RequestBody CommonRequest<DictionaryVO> commonRequest) {
        DictionaryIdsDTO dictionaryListDto = new DictionaryIdsDTO();
        PojoUtils.copyProperties(commonRequest.getBody(), dictionaryListDto);
        dictionaryService.deleteDictionaryByIds(dictionaryListDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ResponseBody
    public CommonResponse<DictionaryVO> updateDictionary(@RequestBody CommonRequest<DictionaryUpdateVO> commonRequest) {
        DictionaryDTO dictionaryDto = new DictionaryDTO();
        DictionaryUpdateVO dictionaryVo = commonRequest.getBody();
        PojoUtils.copyProperties(dictionaryVo, dictionaryDto);
        dictionaryDto = dictionaryService.updateDictionary(dictionaryDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    @ApiLog(msg = "分页查询全部字典数据")
    @ResponseBody
    public CommonResponse<CommonPage<DictionaryVO>> queryDictionary(@RequestBody CommonRequest<CommonPageRequest<DictionaryQueryVO>> commonRequest) {
        Page<Object> page=this.doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
        List<DictionaryDTO> dictionaryDTOS = dictionaryService.getDictionary();
        List<DictionaryVO> dictionaryVos = PojoUtils.copyListProperties(dictionaryDTOS, DictionaryVO::new);
        return buildPageResponse(page,dictionaryVos);

    }

    @Override
    @ApiLog(msg = "分页查询字典")
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
    public List<DifficultQueryDTO> queryCategory(@RequestBody DifficultQueryDTO difficultQueryDTO) {
        return dictionaryService.queryCategory(difficultQueryDTO);
    }
}
