package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.DictionaryApi;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryIdsDTO;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import com.boss.xtrain.basedata.pojo.vo.dictionary.*;
import com.boss.xtrain.basedata.service.DictionaryService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.list.AbstractLinkedList;
import org.bouncycastle.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class DictionaryController implements DictionaryApi {

    @Autowired
    private DictionaryService dictionaryService;


    @Override
    @ApiLog(msg = "新增字典")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<DictionaryVO> insertDictionary(@RequestBody @Validated CommonRequest<DictionaryInsertVO> commonRequest) {
        DictionaryDTO dictionaryDTO = new DictionaryDTO();
        DictionaryInsertVO dictionaryInsertVO = commonRequest.getBody();
        log.info(commonRequest.toString());
        PojoUtils.copyProperties(dictionaryInsertVO,dictionaryDTO);
        dictionaryDTO = dictionaryService.insertDictionary(dictionaryDTO);

        PojoUtils.copyProperties(dictionaryDTO,dictionaryInsertVO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }

    @Override
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
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
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<Boolean> deleteDictionary(@RequestBody CommonRequest<DictionaryDeleteVO> commonRequest) {
        DictionaryDTO dictionaryDto = new DictionaryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(), dictionaryDto);
        dictionaryService.insertDictionary(dictionaryDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<Boolean> deleteDictionaryByIds(@RequestBody CommonRequest<DictionaryVO> commonRequest) {
        DictionaryIdsDTO dictionaryListDto = new DictionaryIdsDTO();
        PojoUtils.copyProperties(commonRequest.getBody(), dictionaryListDto);
        dictionaryService.deleteDictionaryByIds(dictionaryListDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);

    }

    @Override
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<DictionaryVO> updateDictionary(@RequestBody CommonRequest<DictionaryUpdateVO> commonRequest) {
        DictionaryDTO dictionaryDto = new DictionaryDTO();
        DictionaryUpdateVO dictionaryVo = commonRequest.getBody();
        PojoUtils.copyProperties(dictionaryVo, dictionaryDto);
        dictionaryDto = dictionaryService.updateDictionary(dictionaryDto);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }

    @Override
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('dictionary_admin')")
    public CommonResponse<List<DictionaryVO>> queryDictionary(@RequestBody CommonRequest<DictionaryQueryVO> commonRequest) {
        List<DictionaryDTO> dictionaryDtos = dictionaryService.getDictionary();
        List<DictionaryVO> dictionaryVos = new ArrayList<>();
        PojoUtils.copyProperties(dictionaryDtos, dictionaryVos);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());

    }
}
