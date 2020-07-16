package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.dto.category.CategoryIdsDTO;
import com.boss.xtrain.basedata.pojo.vo.category.*;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.*;
;

import java.util.List;

@RequestMapping("/category")
@CrossOrigin
public interface CategoryApi {

    @PostMapping("/insertCategory")
    CommonResponse<CategoryVO> insertCategory(CommonRequest<CategoryVO> commonRequest);

    @PostMapping("/deleteCategory")
    CommonResponse<Boolean> deleteCategory(CommonRequest<CategoryDeleteIdsVO> commonRequest);

    @PostMapping("/updateCategory")
    CommonResponse<CategoryVO> updateCategory(CommonRequest<CategoryVO> commonRequest);

    @PostMapping("/queryCategoryList")
    List<CategoryVO> getCategoryList(CategoryQueryVO categoryQueryVo);

    @PostMapping("/queryCategoryPage")
    CommonResponse<CommonPage<CategoryVO>> queryCategoryPage(CommonRequest<CategoryQueryVO> commonRequest);

    @PostMapping("/queryCategoryTree")
    CommonResponse<List<CategoryTreeVO>> getCategoryTree(CommonRequest<CategoryQueryVO> commonRequest);

    @PostMapping("/getAll")
    CommonResponse<CommonPage<CategoryVO>> getCategory(CommonRequest<CategoryIdsVO> commonRequest);
}
