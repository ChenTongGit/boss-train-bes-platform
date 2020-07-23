package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;
import com.boss.xtrain.permission.pojo.vo.UserOnlineInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.08
 */
@RequestMapping("/education/bes/v1/onlineInfo")
public interface UserOnlineInfoApi extends CommonCRUDApi<UserOnlineInfoDTO, UserOnlineInfoQuery, UserOnlineInfoVO> {
    /**
     * 分页条件搜索
     * @param request 带条件的分页搜索
     * @return 条件搜索列表
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<UserOnlineInfoVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<UserOnlineInfoQuery>> request);

    /**
     * 分页全搜索
     * @param request 不带条件的分页搜索
     * @return 全搜索列表
     */
    @PostMapping("/selectAllPage")
    CommonResponse<CommonPage<UserOnlineInfoVO>> selectAllPage(@RequestBody @Valid CommonRequest<CommonPageRequest<UserOnlineInfoQuery>> request);

    /**
     * 批量下线
     * @param request 请求下线的用户list
     * @return 下线结果
     */
    @PutMapping("/updateBatch")
    CommonResponse<Integer> updateList(@RequestBody @Valid CommonRequest<List<UserOnlineInfoDTO>> request);
}