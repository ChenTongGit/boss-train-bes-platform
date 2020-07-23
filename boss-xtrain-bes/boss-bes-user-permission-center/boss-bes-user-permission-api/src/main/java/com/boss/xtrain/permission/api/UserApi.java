package com.boss.xtrain.permission.api;


import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.ExamServiceUsersDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
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
     * @author ysq
     * @param request 请求报文对象，传递dto
     * @return 返回类型：com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     */
    @PostMapping("/insert")
    CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<UserDTO> request);

    /**
     * 查询数据 返回数据vo列表
     * @author ysq
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：CommonResponse<List<UserListVO>>
     */
    @PostMapping("/selectList")
    CommonResponse<List<UserListVO>> selectList(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    /**
     * 查找指定查询条件的数据
     * @author ysq
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：CommonResponse<UserListVO>
     */
    @PostMapping("/select")
    CommonResponse<UserListVO> select(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    /**
     * 指定删除某个数据数据
     * @author ysq
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     */
    @DeleteMapping("/delete")
    CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<UserDTO> request);

    /**
     * 批量删除数据
     * @author ysq
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     */
    @DeleteMapping("/deleteBatch")
    CommonResponse<Integer> deleteBatch(@RequestBody @Valid CommonRequest<List<UserDTO>> request);

    /**
     * 更新数据
     * @author ysq
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     */
    @PutMapping("update")
    CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<UserDTO> request);
    /**
     * 列出所有
     *
     * @return 返回类型： CommonResponse<List<UserListVO>>
     *
     */
    @RequestMapping("/selectAll")
    CommonResponse<List<UserListVO>> selectAllUser();

    /**
     *
     * 用户的所有角色
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：CommonResponse<List<RoleListVO>>
     *
    */
    @PostMapping("/getRoleList")
    CommonResponse<List<RoleListVO>> getAllRole(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    /**
     *
     * 用户的所有资源
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：CommonResponse<List<ResourceListVO>>
     *
    */
    @PostMapping("/getAllResource")
    CommonResponse<List<ResourceListVO>> getAllResource(@RequestBody @Valid CommonRequest<RoleQueryDTO> request);

    /**
     * 带有分页的搜索功能
     *
     * @param request 搜索条件封装类
     * @return 返回类型：CommonResponse<CommonPage<UserListVO>>
     *
    */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<UserListVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<UserQueryDTO>> request);
    /**
     * 带有分页的列出所有功能
     *
     * @param request 搜索条件封装类
     * @return 返回类型：CommonResponse<CommonPage<UserListVO>>
     *
     */
    @PostMapping("/selectAllByPage")
    CommonResponse<CommonPage<UserListVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest> request);
    /**
     *
     * 分配角色
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return boolean
     *
    */
    @RequestMapping("/allocateRole")
    CommonResponse<Boolean> allocateRole(@RequestBody @Valid CommonRequest<List<UserRoleDTO>> request);

    /**
     * 查询用户的角色列表
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return CommonResponse<List<RoleListVO>>
     *
    */
    @RequestMapping("/getRoles")
    CommonResponse<List<RoleListVO>> getRoles(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

    /**
     * 通过position查找用户
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return CommonResponse<List<UserListVO>>
     *
    */
    @RequestMapping("/getUserByPosition")
    CommonResponse<List<ExamServiceUsersDTO>> getUserByPosition(@RequestBody @Valid CommonRequest<UserQueryDTO> request);

}

