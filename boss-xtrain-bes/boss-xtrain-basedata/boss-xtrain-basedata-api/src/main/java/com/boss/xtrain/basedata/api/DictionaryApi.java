package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.dictionary.*;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author gxr
 * @description 字典接口类
 * @date 2020/7/8
 */
@RequestMapping("/dictionary")
public interface DictionaryApi {

    /**
     * 插入一条数据字典
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertDictionary")
    CommonResponse<DictionaryVO> insertDictionary(CommonRequest<DictionaryInsertVO> commonRequest);

    /**
     * 批量插入字典，也就是导入
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertDictionaryList")
    CommonResponse<List<DictionaryVO>> insertDictionaryList(CommonRequest<List<DictionaryInsertVO>> commonRequest);

    /**
     * 删除一条字典
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteDictionary")
    CommonResponse<Boolean> deleteDictionary(CommonRequest<DictionaryDeleteVO> commonRequest);

    /**
     * 批量删除字典
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteDictionaryList")
    CommonResponse<Boolean> deleteDictionaryByIds(CommonRequest<List<DictionaryDeleteVO>> commonRequest);

    /**
     * 更新字典
     * @param commonRequest
     * @return
     */
    @PostMapping("/updateDictionary")
    CommonResponse<DictionaryVO> updateDictionary(CommonRequest<DictionaryUpdateVO> commonRequest);

    /**
     * 分页查询字典所有数据
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryDictionary")
    CommonResponse<CommonPage<DictionaryVO>> queryDictionary(CommonRequest<CommonPageRequest<DictionaryQueryVO>> commonRequest);

    /**
     *
     * 分页查询字典
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryDictionaryPage")
    CommonResponse<CommonPage<DictionaryVO>> queryDictionaryPage(CommonRequest<CommonPageRequest<DictionaryQueryVO>> commonRequest);

    /**
     * 提供给系统服务，返回name
     * @return
     */
    @GetMapping("/queryCategory")
    CommonResponse<List<DifficultQueryDTO>> queryCategory();

    /**
     * 查询category字典类别列表
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryCategoryList")
    CommonResponse<List<DictionaryVO>> queryCategoryList(CommonRequest<DictionaryVO> commonRequest);

}
