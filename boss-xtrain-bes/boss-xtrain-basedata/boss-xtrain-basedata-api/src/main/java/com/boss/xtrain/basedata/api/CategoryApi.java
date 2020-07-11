package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryDeleteVO;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryQueryVO;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryVO;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;;

import java.util.List;

@RequestMapping("/category")
public interface CategoryApi {

    @RequestMapping("/insertCategory")
    CommonResponse<CategoryVO> insertCategory(CommonRequest<CategoryVO> commonRequest);

    @PostMapping("/deleteCategory")
    CommonResponse<Boolean> deleteCategory(CommonRequest<CategoryDeleteVO> commonRequest);


    @PostMapping("/updateCategory")
    CommonResponse<CategoryVO> updateCategory(CommonRequest<CategoryVO> commonRequest);


    @PostMapping("/queryCategoryList")
    List<CategoryVO> getCategoryList(CategoryQueryVO categoryQueryVo);

    /**
     * 分页显示题目类别
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryCategory")
    CommonResponse<CommonPage<CategoryVO>> queryCategoryPage(CommonRequest<CategoryQueryVO> commonRequest);

}
