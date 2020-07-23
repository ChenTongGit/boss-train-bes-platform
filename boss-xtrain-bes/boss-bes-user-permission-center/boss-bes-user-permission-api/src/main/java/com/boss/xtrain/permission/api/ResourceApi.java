package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.query.TreeNode;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 列出所有
     *
     * @return 返回类型：body为Resource列表
     */
    @RequestMapping("/selectAll")
    CommonResponse<List<ResourceListVO>> selectAllResource();

    /**
     *
     * 带有分页功能的搜索
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return body为带有page的ResourceListVO列表
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<ResourceListVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<ResourceQueryDTO>> request);
    /**
     * 带有分页功能的全搜索
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return body为带有page的ResourceListVO列表
     */
    @PostMapping("/selectAllByPage")
    CommonResponse<CommonPage<ResourceListVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest> request);
    /**
     * 搜索资源树
     *
     * @param request 请求报文对象，传递query（本质也为dto），body为查询条件
     * @return 返回类型为：body为treeNode
     */
    @PostMapping("selectResourceTree")
    CommonResponse<List<TreeNode>> selectResourceTree(@RequestBody CommonRequest<ResourceQueryDTO> request);
}
