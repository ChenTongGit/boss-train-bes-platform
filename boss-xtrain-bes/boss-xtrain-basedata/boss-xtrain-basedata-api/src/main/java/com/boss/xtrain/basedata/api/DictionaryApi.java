package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.vo.dictionary.*;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/dictionary")
public interface DictionaryApi {

    @PostMapping("/insertDictionary")
    CommonResponse<DictionaryVO> insertDictionary(CommonRequest<DictionaryInsertVO> commonRequest);

    @PostMapping("/insertDictionaryList")
    CommonResponse<DictionaryVO> insertDictionaryList(CommonRequest<List<DictionaryInsertVO>> commonRequest);

    @PostMapping("/deleteDictionary")
    CommonResponse<Boolean> deleteDictionary(CommonRequest<DictionaryDeleteVO> commonRequest);

    @PostMapping("/deleteDictionary/Batches")
    CommonResponse<Boolean> deleteDictionaryByIds(CommonRequest<DictionaryVO> commonRequest);

    @PostMapping("/updateDictionary")
    CommonRequest<DictionaryVO> updateDictionary(CommonRequest<DictionaryUpdateVO> commonRequest);

    @PostMapping("/queryDictionary")
    CommonResponse<List<DictionaryVO>> queryDictionary(CommonRequest<DictionaryQueryVO> commonRequest);




}
