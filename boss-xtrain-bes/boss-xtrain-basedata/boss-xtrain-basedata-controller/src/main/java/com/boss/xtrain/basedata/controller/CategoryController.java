package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.CategoryApi;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDTO;
import com.boss.xtrain.basedata.pojo.dto.category.CategoryDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryDeleteVO;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryQueryVO;
import com.boss.xtrain.basedata.pojo.vo.category.CategoryVO;
import com.boss.xtrain.basedata.pojo.vo.dictionary.DictionaryInsertVO;
import com.boss.xtrain.basedata.service.CategoryService;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    @ApiLog(msg = "新增题目类别")
    @ResponseBody
    public CommonResponse<CategoryVO> insertCategory(@RequestBody CommonRequest<CategoryVO> commonRequest) {
        CategoryVO categoryVO = new CategoryVO();
        Iterator<String> iterator = commonRequest.getBody().keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            categoryVO = commonRequest.getBody().get(key);
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        PojoUtils.copyProperties(categoryVO,categoryDTO);
        categoryService.insertCategory(categoryDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }

    @Override
    public CommonResponse<Boolean> deleteCategory(CommonRequest<CategoryDeleteVO> commonRequest) {
        CategoryDeleteDTO categoryDeleteDTO = new CategoryDeleteDTO();

        return null;
    }

    @Override
    @ApiLog(msg = "修改题目类别")
    @ResponseBody
    public CommonResponse<CategoryVO> updateCategory(@RequestBody CommonRequest<CategoryVO> commonRequest) {
        CategoryVO categoryVO = new CategoryVO();
        Iterator<String> iterator = commonRequest.getBody().keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            categoryVO = commonRequest.getBody().get(key);
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        PojoUtils.copyProperties(categoryVO,categoryDTO);
        categoryService.updateCategory(categoryDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage());
    }

    @Override
    public List<CategoryVO> getCategoryList(CategoryQueryVO categoryQueryVo) {
        return null;
    }

    @Override
    @ApiLog(msg = "分页查询题目类别")
    @ResponseBody
    public CommonResponse<CommonPage<CategoryVO>> queryCategoryPage(@RequestBody CommonRequest<CategoryQueryVO> commonRequest) {

        return null;
    }
}
