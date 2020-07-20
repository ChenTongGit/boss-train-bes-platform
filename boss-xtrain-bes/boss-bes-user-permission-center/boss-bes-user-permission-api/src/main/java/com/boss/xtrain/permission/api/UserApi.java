package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import com.boss.xtrain.permission.pojo.vo.UserListVO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:54 2020/07/09
 * @Description :userapi 接口设计
 * @Version: 1.0
 */
@RequestMapping("/education/bes/v1/user")
public interface UserApi {
    /**
     * 添加新的数据
     * @author ChenTong
     * @param request 请求报文对象，传递dto
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @date 2020/7/7 22:09
     */
    @PostMapping("/insert")
    CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<UserDTO> request);

    /**
     * 查询数据 返回数据vo列表
     * @author ChenTong
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return CommonResponse<List<UserListVO>>
     * @date 2020/7/7 22:09
     */
    @PostMapping("/selectList")
    CommonResponse<List<UserListVO>> selectList(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    /**
     * 查找指定查询条件的数据
     * @author ChenTong
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return CommonResponse<UserListVO>
     * @date 2020/7/7 22:09
     */
    @PostMapping("/select")
    CommonResponse<UserListVO> select(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    /**
     * 指定删除某个数据数据
     * @author ChenTong
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @date 2020/7/7 22:09
     */
    @DeleteMapping("/delete")
    CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<UserDTO> request);

    /**
     * 批量删除数据
     * @author ChenTong
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @date 2020/7/7 22:09
     */
    @DeleteMapping("/deleteBatch")
    CommonResponse<Integer> deleteBatch(@RequestBody @Valid CommonRequest<List<UserDTO>> request);

    /**
     * 更新数据
     * @author ChenTong
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @date 2020/7/7 22:10
     */
    @PutMapping("update")
    CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<UserDTO> request);
    /**
     * 列出所有
     *
     * @param
     * @return CommonResponse<List<UserListVO>>
     *
     */
    @RequestMapping("/selectAll")
    CommonResponse<List<UserListVO>> selectAllUser();

    /**
     *
     * 用户的所有角色
     * @param request
     * @return CommonResponse<List<RoleListVO>>
     *
    */
    @PostMapping("/getRoleList")
    CommonResponse<List<RoleListVO>> getAllRole(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    /**
     *
     * 用户的所有资源
     * @param request
     * @return CommonResponse<List<ResourceListVO>>
     *
    */
    @PostMapping("/getAllResource")
    CommonResponse<List<ResourceListVO>> getAllResource(@RequestBody @Valid CommonRequest<RoleQueryDTO> request);

}

