package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.permission.pojo.vo.SystemParamVO;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author 53534 秦昀清
 * @date 2020.07.07
 */
@RequestMapping("/education/bes/v1/systemParam")
public interface SystemParamApi extends CommonCRUDApi<SystemParamDTO, SystemParamQuery, SystemParamVO> {
    /**
     * 分页条件搜索
     * @param request 带条件的分页搜索
     * @return 条件搜索到的该登录人所负责的组织机构的系统参数列表
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<SystemParamVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<SystemParamQuery>> request);

    /**
     * 分页全搜索
     * @param request 只带分页条件的搜索
     * @return 所有该登录人所负责的组织机构的系统参数列表
     */
    @PostMapping("/selectAllByPage")
    CommonResponse<CommonPage<SystemParamVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<SystemParamQuery>> request);

    /**
     * 禁用/启用 更改status
     * @param request 没用到
     * @return 没用到
     */
    @PostMapping("/changeStatus")
    CommonResponse<Integer> changeUse(@RequestBody @Valid CommonRequest<SystemParamDTO> request);

    /**
     * 使用type来删除同类型的所有系统参数
     * @param request 带有type的删除请求
     * @return 删除结果
     */
    @DeleteMapping("/deleteBatchByType")
    CommonResponse<Integer> deleteBatchByType(@RequestBody @Valid CommonRequest<SystemParamQuery> request);

}
