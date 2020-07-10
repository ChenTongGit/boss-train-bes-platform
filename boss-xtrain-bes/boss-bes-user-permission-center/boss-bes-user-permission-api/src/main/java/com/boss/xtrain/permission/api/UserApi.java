package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.UserListVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:54 2020/07/09
 * @Description :userapi 接口设计
 * @Version: 1.0
 */
@RequestMapping("/education/bes/v1/user")
public interface UserApi extends CommonCRUDApi<UserDTO,UserQueryDTO,UserListVO> {
    /**
     * 添加用户
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/add")
    @Override
    CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<UserDTO> request);
    /**
     *删除用户
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/delete")
    @Override
    CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<UserDTO> request);

    /**
     * 查询用户信息
     *
     * @param request
     * @return CommonResponse<List<ResourceListVO>>
     *
     */
    @RequestMapping("/selectList")
    @Override
    CommonResponse<List<UserListVO>> selectList(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    /**
     * 唯一查询
     *
     * @param request
     * @return CommonResponse<ResourceListVO>
     *
     */
    @RequestMapping("/selectOne")
    @Override
    CommonResponse<UserListVO> select(@RequestBody @Valid CommonRequest<UserQueryDTO> request);


    /**
     * 修改用户
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/update")
    @Override
    CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<UserDTO> request);

    /**
     * 批量删除
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @Override
    @RequestMapping("/deletePath")
    CommonResponse<Integer> deletePatch(@RequestBody @Valid CommonRequest<List<UserDTO>> request);
}
