package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.vo.category.*;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.paper.dto.baseinfo.CombInfoQueryDTO;
import com.boss.xtrain.paper.vo.baseinfo.SubjectCategoryVO;
import org.springframework.web.bind.annotation.*;
;

import java.util.List;

/**
 * @author gxr
 * @description 题目类别接口
 * @date 2020/7/11
 */
@RequestMapping("/category")
public interface CategoryApi {

    /**
     * 插入题目类别
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertCategory")
    CommonResponse<CategoryVO> insertCategory(CommonRequest<CategoryVO> commonRequest);

    /**
     * 删除题目类别
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteCategory")
    CommonResponse<Boolean> deleteCategory(CommonRequest<CategoryDeleteIdsVO> commonRequest);

    /**
     * 更新题目类别
     * @param commonRequest
     * @return
     */
    @PostMapping("/updateCategory")
    CommonResponse<CategoryVO> updateCategory(CommonRequest<CategoryVO> commonRequest);

    /**
     * 获取题目类别列表
     * @param categoryQueryVo
     * @return
     */
    @PostMapping("/queryCategoryList")
    List<CategoryVO> getCategoryList(CategoryQueryVO categoryQueryVo);

    /**
     * 分页查询获取题目类别
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryCategoryPage")
    CommonResponse<CommonPage<CategoryVO>> queryCategoryPage(CommonRequest<CommonPageRequest<CategoryQueryVO>> commonRequest);

    /**
     * 获取树
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryCategoryTree")
    CommonResponse<List<CategoryTreeVO>> getCategoryTree(CommonRequest<CategoryQueryVO> commonRequest);

    /**
     * 查询子节点
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryTree")
    CommonResponse<CommonPage<CategoryVO>> getCategory(CommonRequest<CommonPageRequest<CategoryIdsVO>> commonRequest);

}
