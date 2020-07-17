package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.permission.pojo.vo.SystemParamVO;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.security.access.prepost.PreAuthorize;
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
     * @param request
     * @return
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<SystemParamVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<SystemParamQuery>> request);

    /**
     * 分页全搜索
     * @param request
     * @return
     */
    @PostMapping("/selectAllByPage")
    CommonResponse<CommonPage<SystemParamVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<SystemParamQuery>> request);

    /**
     * 禁用/启用 更改status
     * @param request
     * @return
     */
    @PostMapping("/changeStatus")
    CommonResponse<Integer> changeUse(@RequestBody @Valid CommonRequest<SystemParamDTO> request);

}
