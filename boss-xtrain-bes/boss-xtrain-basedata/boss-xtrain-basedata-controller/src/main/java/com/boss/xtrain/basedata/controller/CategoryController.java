package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.basedata.api.CategoryApi;
import com.boss.xtrain.basedata.pojo.dto.category.*;
import com.boss.xtrain.basedata.pojo.vo.category.*;
import com.boss.xtrain.basedata.service.CategoryService;
import com.boss.xtrain.basedata.utils.TreeUtil;
import com.boss.xtrain.common.core.exception.error.SystemError;
import com.boss.xtrain.common.core.http.*;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类别controller
 * @date 2020/07/08
 */
@RestController
@Slf4j
public class CategoryController extends BaseController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    @ApiLog(msg = "新增题目类别")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('category_admin')")
    public CommonResponse<CategoryVO> insertCategory(@RequestBody CommonRequest<CategoryVO> commonRequest) {
        CategoryVO categoryVO = commonRequest.getBody();
        CategoryDTO categoryDTO = new CategoryDTO();
        log.info(categoryVO.toString());
        if (categoryVO.getParentId().equals("")){
            categoryVO.setParentId(null);
        }else {
            categoryDTO.setParentId(Long.valueOf(categoryVO.getParentId()));
        }
        PojoUtils.copyProperties(categoryVO,categoryDTO);
        categoryService.insertCategory(categoryDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),categoryVO);
    }

    @Override
    @ApiLog(msg = "删除题目类别")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('category_admin')")
    public CommonResponse<Boolean> deleteCategory(@RequestBody CommonRequest<CategoryDeleteIdsVO> commonRequest) {
        CategoryDeleteIdsVO categoryDeleteIdsVO =  commonRequest.getBody();
        CategoryDeleteIdsDTO categoryDeleteIdsDTO = new CategoryDeleteIdsDTO();
        List<CategoryDeleteDTO> categoryDeleteDTOS = PojoUtils.copyListProperties(categoryDeleteIdsVO.getIds(),CategoryDeleteDTO::new);
        categoryDeleteIdsDTO.setIds(categoryDeleteDTOS);
        categoryService.deleteCategory(categoryDeleteIdsDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);
    }

    @Override
    @ApiLog(msg = "修改题目类别")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('category_admin')")
    public CommonResponse<CategoryVO> updateCategory(@RequestBody CommonRequest<CategoryVO> commonRequest) {
        CategoryVO categoryVO = commonRequest.getBody();
        CategoryDTO categoryDTO = new CategoryDTO();
        PojoUtils.copyProperties(categoryVO,categoryDTO);
        categoryService.updateCategory(categoryDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),categoryVO);
    }

    @Override
    @ApiLog(msg = "获取所有题目类别（不分页）")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('category_admin')")
    public List<CategoryVO> getCategoryList(@RequestBody CategoryQueryVO categoryQueryVo) {
        CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
        CategoryQueryVO categoryQueryVO = new CategoryQueryVO();
        PojoUtils.copyProperties(categoryQueryVO,categoryQueryDTO);
        List<CategoryDTO> categoryDTOS = categoryService.queryCategory(categoryQueryDTO);
        List<CategoryVO> categoryVOS = new ArrayList<>();
        PojoUtils.copyProperties(categoryDTOS,categoryVOS);
        return categoryVOS;
    }

    @Override
    @ApiLog(msg = "分页查询题目类别")
    @ResponseBody
    public CommonResponse<CommonPage<CategoryVO>> queryCategoryPage(@RequestBody CommonRequest<CommonPageRequest<CategoryQueryVO>> commonRequest) {
        CategoryQueryVO categoryQueryVO = commonRequest.getBody().getQuery();
        CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
        PojoUtils.copyProperties(categoryQueryVO, categoryQueryDTO);
        Page<Object> objects = this.doBeforePagination(commonRequest.getBody().getPageNum(), commonRequest.getBody().getPageSize(), commonRequest.getBody().getOrderBy());
        List<CategoryDTO> categoryDTOS = categoryService.queryCategoryPage(categoryQueryDTO);
        List<CategoryVO> categoryVOS = PojoUtils.copyListProperties(categoryDTOS, CategoryVO::new);
        return buildPageResponse(objects, categoryVOS);
    }

    @Override
    @ApiLog(msg = "树状获取题目类别")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('category_admin')")
    public CommonResponse<List<CategoryTreeVO>> getCategoryTree(@RequestBody CommonRequest<CategoryQueryVO> commonRequest) {
        CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),categoryQueryDTO);
        List<CategoryTreeDTO> categoryTreeDTOList = categoryService.queryCategoryTree(categoryQueryDTO);
        List<CategoryTreeVO> categoryTreeVOList = PojoUtils.copyListProperties(categoryTreeDTOList,CategoryTreeVO::new);
        for(CategoryTreeVO c : categoryTreeVOList){
            c.setLabel(c.getName());
            c.setValue(c.getId());
        }
        List<CategoryTreeVO> data = TreeUtil.getTreeList("0",categoryTreeVOList);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),data);
    }

    @Override
    @ApiLog(msg = "查询题目类别")
    @ResponseBody
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('category_admin')")
    public CommonResponse<CommonPage<CategoryVO>> getCategory(@RequestBody CommonRequest<CommonPageRequest<CategoryIdsVO>> commonRequest) {
        CategoryIdsDTO categoryIdListDTO = new CategoryIdsDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),categoryIdListDTO);
        Page<Object> objects = this.doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
        List<CategoryDTO> categoryDtoList = categoryService.queryByIdList(categoryIdListDTO);
        List<CategoryVO> categoryVOS = PojoUtils.copyListProperties(categoryDtoList,CategoryVO::new);
        return buildPageResponse(objects,categoryVOS);

    }
}
