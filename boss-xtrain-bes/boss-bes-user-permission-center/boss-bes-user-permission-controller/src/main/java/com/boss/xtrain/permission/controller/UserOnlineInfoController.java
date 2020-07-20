package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.api.UserOnlineInfoApi;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;
import com.boss.xtrain.permission.pojo.vo.UserOnlineInfoVO;
import com.boss.xtrain.permission.service.UserOnlineInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534 秦昀清
 * @date 2020.07.09
 */
@RestController
public class UserOnlineInfoController extends BaseController implements UserOnlineInfoApi {

    @Autowired
    private UserOnlineInfoService service;

    /**
     * 分页条件搜索
     *
     * @param request
     * @return
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "分页条件查找在线用户信息并排序")
    @PreAuthorize("hasAuthority('ROLE_admin') OR hasAuthority('user_online_admin')")
    public CommonResponse<CommonPage<UserOnlineInfoVO>> selectByPage(@Valid CommonRequest<CommonPageRequest<UserOnlineInfoQuery>> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        List<UserOnlineInfoDTO> infoDTOList = service.selectByCondition(request.getBody().getQuery());
        List<UserOnlineInfoVO> userOnlineInfoVOList = PojoUtils.copyListProperties(infoDTOList,UserOnlineInfoVO::new);
        return buildPageResponse(page,userOnlineInfoVOList);
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_admin') OR hasAuthority('user_online_admin')")
    public CommonResponse<CommonPage<UserOnlineInfoVO>> selectAllPage(@Valid CommonRequest<CommonPageRequest<UserOnlineInfoQuery>> request) {
        Page<Object> page = doBeforePagination(request.getBody().getPageNum(),request.getBody().getPageSize(),request.getBody().getOrderBy());
        //传入登录的userId，获得该管理员所负责的org
        List<UserOnlineInfoDTO> infoDTOList = service.selectAll(request.getBody().getQuery());
        List<UserOnlineInfoVO> userOnlineInfoVOList = PojoUtils.copyListProperties(infoDTOList,UserOnlineInfoVO::new);
        return buildPageResponse(page,userOnlineInfoVOList);
    }

    /**
     * 批量下线
     *
     * @param request
     * @return
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "批量强制下线")
    @PreAuthorize("hasAuthority('ROLE_admin') OR hasAuthority('user_online_admin')")
    public CommonResponse<Integer> updateList(@Valid CommonRequest<List<UserOnlineInfoDTO>> request) {
        return null;
    }

    /**
     * 添加新的数据
     * --->>>>>login登录
     * @param request 请求报文对象，传递dto
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/7 22:09
     */
    @Override
    @ApiOperation(value = "test")
    @ApiLog(msg = "登录，添加用户在线信息")
    @PreAuthorize("hasAuthority('ROLE_admin') OR hasAuthority('user_online_admin')")
    public CommonResponse<Integer> insert(@Valid CommonRequest<UserOnlineInfoDTO> request) {
        UserOnlineInfoDTO infoDTO = request.getBody();
        return CommonResponseUtil.ok(service.insert(infoDTO));
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
    @ApiOperation(value = "test")
    @ApiLog(msg = "模糊查询指定条件信息")
    @PreAuthorize("hasAuthority('ROLE_admin') OR hasAuthority('user_online_admin')")
    public CommonResponse<List<UserOnlineInfoVO>> selectList(@Valid CommonRequest<UserOnlineInfoQuery> request) {
        UserOnlineInfoQuery infoQuery = request.getBody();
        List<UserOnlineInfoDTO> infoDTOList = service.selectByCondition(infoQuery);
        List<UserOnlineInfoVO> infoVOList = PojoUtils.copyListProperties(infoDTOList,UserOnlineInfoVO::new);
        return CommonResponseUtil.ok(infoVOList);
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
    @ApiOperation(value = "test")
    @ApiLog(msg = "查找一个指定条件的数据")
    @PreAuthorize("hasAuthority('ROLE_admin') OR hasAuthority('user_online_admin')")
    public CommonResponse<UserOnlineInfoVO> select(@Valid CommonRequest<UserOnlineInfoQuery> request) {
        UserOnlineInfoQuery infoQuery = request.getBody();
        UserOnlineInfoDTO infoDTO = service.selectOne(infoQuery);
        UserOnlineInfoVO infoVO = new UserOnlineInfoVO();
        PojoUtils.copyProperties(infoDTO,infoVO);
        return CommonResponseUtil.ok(infoVO);
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
    @ApiOperation(value = "test")
    @ApiLog(msg = "删除一个已经下线的不需要的多余数据")
    @PreAuthorize("hasAuthority('ROLE_admin') OR hasAuthority('user_online_admin')")
    public CommonResponse<Integer> delete(@Valid CommonRequest<UserOnlineInfoDTO> request) {
        UserOnlineInfoDTO infoDTO = request.getBody();
        return CommonResponseUtil.ok(service.delete(infoDTO));
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
    @ApiOperation(value = "test")
    @ApiLog(msg = "批量删除已经下线的不需要的多余数据")
    @PreAuthorize("hasAuthority('ROLE_admin') OR hasAuthority('user_online_admin')")
    public CommonResponse<Integer> deleteBatch(@Valid CommonRequest<List<UserOnlineInfoDTO>> request) {
        List<UserOnlineInfoDTO> infoDTOList = request.getBody();
        return CommonResponseUtil.ok(service.delete(infoDTOList));
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
    @ApiLog(msg = "强制下线")
    @ApiOperation(value = "test")
    public CommonResponse<Integer> update(@Valid CommonRequest<UserOnlineInfoDTO> request) {
        return null;
    }
}
