package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.DictionaryApi;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.vo.dictionary.*;
import com.boss.xtrain.basedata.service.DictionaryService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public CommonResponse<DictionaryVO> insertDictionary(@RequestBody @Validated CommonRequest<DictionaryInsertVO> commonRequest) {
        DictionaryDTO dictionaryDTO = new DictionaryDTO();
        DictionaryInsertVO dictionaryInsertVO = new DictionaryInsertVO();
        log.info(commonRequest.toString());
        Iterator<String> iterator = commonRequest.getBody().keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            dictionaryInsertVO = commonRequest.getBody().get(key);
            log.info(key + " " + dictionaryDTO);
        }
        PojoUtils.copyProperties(dictionaryInsertVO,dictionaryDTO);
        dictionaryDTO = dictionaryService.insertDictionary(dictionaryDTO);

        PojoUtils.copyProperties(dictionaryDTO,dictionaryInsertVO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }

    @Override
    public CommonResponse<DictionaryVO> insertDictionaryList(CommonRequest<List<DictionaryInsertVO>> commonRequest) {
        return null;
    }

    @Override
    public CommonResponse<Boolean> deleteDictionary(CommonRequest<DictionaryDeleteVO> commonRequest) {
        return null;
    }

    @Override
    public CommonResponse<Boolean> deleteDictionaryByIds(CommonRequest<DictionaryVO> commonRequest) {
        return null;
    }

    @Override
    public CommonRequest<DictionaryVO> updateDictionary(CommonRequest<DictionaryUpdateVO> commonRequest) {
        return null;
    }

    @Override
    public CommonResponse<List<DictionaryVO>> queryDictionary(CommonRequest<DictionaryQueryVO> commonRequest) {
        return null;
    }
}
