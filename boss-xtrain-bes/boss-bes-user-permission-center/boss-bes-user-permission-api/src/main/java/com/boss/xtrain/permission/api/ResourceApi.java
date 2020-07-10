package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:48 2020/07/09
 * @Description :resource api
 * @Version:
 */
@RequestMapping("/education/bes/v1/resource")
public interface ResourceApi extends CommonCRUDApi<ResourceDTO,ResourceQueryDTO,ResourceListVO> {
    /**
     * 添加资源
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/add")
    @Override
    CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<ResourceDTO> request);
    /**
     *删除资源
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/delete")
    @Override
    CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<ResourceDTO> request);

    /**
     * 查询资源信息
     *
     * @param request
     * @return CommonResponse<List<ResourceListVO>>
     *
     */
    @RequestMapping("/selectList")
    @Override
    CommonResponse<List<ResourceListVO>> selectList(@RequestBody @Valid CommonRequest<ResourceQueryDTO> request);

    /**
     * 唯一查询
     *
     * @param request
     * @return CommonResponse<ResourceListVO>
     *
     */
    @RequestMapping("/selectOne")
    @Override
    CommonResponse<ResourceListVO> select(@RequestBody @Valid CommonRequest<ResourceQueryDTO> request);


    /**
     * 修改资源
     *
     * @param request
     * @return CommonResponse<Integer>
     *
     */
    @RequestMapping("/updatePosition")
    @Override
    CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<ResourceDTO> request);

    /**
     * 批量删除
     *
     * @param request
     * @return CommonResponse<Integer>
     *
    */
    @Override
    @RequestMapping("/deletePath")
    CommonResponse<Integer> deletePatch(@RequestBody @Valid CommonRequest<List<ResourceDTO>> request);
}
