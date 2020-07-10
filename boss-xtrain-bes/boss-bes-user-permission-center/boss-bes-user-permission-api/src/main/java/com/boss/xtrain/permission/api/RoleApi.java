package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:51 2020/07/09
 * @Description :role api 接口设计
 * @Version: 1.0
 */
@RequestMapping("/education/bes/v1/role")
public interface RoleApi extends CommonCRUDApi<RoleDTO,ResourceQueryDTO,RoleListVO> {
    /**
     * 添加角色
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/add")
    @Override
    CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<RoleDTO> request);
    /**
     *删除角色
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/delete")
    @Override
    CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<RoleDTO> request);

    /**
     * 查询角色信息
     *
     * @param request
     * @return CommonResponse<List<ResourceListVO>>
     *
     */
    @RequestMapping("/selectList")
    @Override
    CommonResponse<List<RoleListVO>> selectList(@RequestBody @Valid CommonRequest<ResourceQueryDTO> request);

    /**
     * 唯一查询
     *
     * @param request
     * @return CommonResponse<ResourceListVO>
     *
     */
    @RequestMapping("/selectOne")
    @Override
    CommonResponse<RoleListVO> select(@RequestBody @Valid CommonRequest<ResourceQueryDTO> request);


    /**
     * 修改角色
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/update")
    @Override
    CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<RoleDTO> request);

    /**
     * 批量删除
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @Override
    @RequestMapping("/deletePath")
    CommonResponse<Integer> deletePatch(@RequestBody @Valid CommonRequest<List<RoleDTO>> request);
}
