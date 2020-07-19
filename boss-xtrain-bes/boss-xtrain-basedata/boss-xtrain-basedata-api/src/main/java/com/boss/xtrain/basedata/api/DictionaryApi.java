package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.dto.subject.DifficultDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.dictionary.*;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/dictionary")
public interface DictionaryApi {

    @PostMapping("/insertDictionary")
    CommonResponse<DictionaryVO> insertDictionary(CommonRequest<DictionaryInsertVO> commonRequest);

    @PostMapping("/insertDictionaryList")
    CommonResponse<List<DictionaryVO>> insertDictionaryList(CommonRequest<List<DictionaryInsertVO>> commonRequest);

    @PostMapping("/deleteDictionary")
    CommonResponse<Boolean> deleteDictionary(CommonRequest<DictionaryDeleteVO> commonRequest);

    @PostMapping("/deleteDictionaryList")
    CommonResponse<Boolean> deleteDictionaryByIds(CommonRequest<DictionaryVO> commonRequest);

    @PostMapping("/updateDictionary")
    CommonResponse<DictionaryVO> updateDictionary(CommonRequest<DictionaryUpdateVO> commonRequest);

    @PostMapping("/queryDictionary")
    CommonResponse<CommonPage<DictionaryVO>> queryDictionary(@RequestBody CommonRequest<CommonPageRequest<DictionaryQueryVO>> commonRequest);

    @PostMapping("/queryDictionaryPage")
    CommonResponse<CommonPage<DictionaryVO>> queryDictionaryPage(CommonRequest<CommonPageRequest<DictionaryQueryVO>> commonRequest);

    @PostMapping("/queryCategory")
    List<DifficultQueryDTO> queryCategory(DifficultQueryDTO difficultQueryDTO);


}
