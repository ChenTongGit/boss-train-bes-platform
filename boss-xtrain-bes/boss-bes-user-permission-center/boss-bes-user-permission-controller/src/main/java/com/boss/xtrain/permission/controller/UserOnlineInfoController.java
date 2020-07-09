package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.api.UserOnlineInfoApi;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;
import com.boss.xtrain.permission.pojo.vo.UserOnlineInfoVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534 秦昀清
 * @date 2020.07.09
 */
@RestController
public class UserOnlineInfoController implements UserOnlineInfoApi {
    /**
     * 分页条件搜索
     *
     * @param request
     * @return
     */
    @Override
    public CommonResponse<CommonPage<UserOnlineInfoVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<UserOnlineInfoQuery>> request) {
        return null;
    }

    /**
     * 批量下线
     *
     * @param request
     * @return
     */
    @Override
    public CommonResponse<Integer> updateList(@Valid CommonRequest<List<UserOnlineInfoDTO>> request) {
        return null;
    }

    /**
     * 添加新的数据
     *
     * @param request 请求报文对象，传递dto
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<UserOnlineInfoDTO> request) {
        return null;
    }

    /**
     * 查询数据 返回数据vo列表
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.util.List < V>>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<List<UserOnlineInfoVO>> selectList(@Valid CommonRequest<UserOnlineInfoQuery> request) {
        return null;
    }

    /**
     * 查找指定查询条件的数据
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonRequest<V>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<UserOnlineInfoVO> select(@Valid CommonRequest<UserOnlineInfoQuery> request) {
        return null;
    }

    /**
     * 指定删除某个数据数据
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<UserOnlineInfoDTO> request) {
        return null;
    }

    /**
     * 批量删除数据
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<UserOnlineInfoDTO>> request) {
        return null;
    }

    /**
     * 强制下线
     *
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:10
     */
    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<UserOnlineInfoDTO> request) {
        return null;
    }
}
