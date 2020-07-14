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
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@CrossOrigin
public class CategoryController extends BaseController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    @ApiLog(msg = "新增题目类别")
    @ResponseBody
    public CommonResponse<CategoryVO> insertCategory(@RequestBody CommonRequest<CategoryVO> commonRequest) {
        CategoryVO categoryVO = commonRequest.getBody();
        log.info("request:",commonRequest.getBody().toString());
        log.info(categoryVO.toString());
        CategoryDTO categoryDTO = new CategoryDTO();
        PojoUtils.copyProperties(categoryVO,categoryDTO);
        categoryService.insertCategory(categoryDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),categoryVO);
    }

    @Override
    @ApiLog(msg = "删除题目类别")
    @ResponseBody
    public CommonResponse<Boolean> deleteCategory(@RequestBody CommonRequest<CategoryDeleteIdsVO> commonRequest) {
        CategoryDeleteIdsVO categoryDeleteIdsVO =  commonRequest.getBody();
        log.info(categoryDeleteIdsVO.toString());
        CategoryDeleteIdsDTO categoryDeleteIdsDTO = new CategoryDeleteIdsDTO();
        PojoUtils.copyProperties(categoryDeleteIdsVO,categoryDeleteIdsDTO);
        categoryService.deleteCategory(categoryDeleteIdsDTO);
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),true);
    }

    @Override
    @ApiLog(msg = "修改题目类别")
    @ResponseBody
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
    public List<CategoryVO> getCategoryList(@RequestBody CategoryQueryVO categoryQueryVo) {
        log.info(categoryQueryVo.toString());
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
    public CommonResponse<CommonPage<CategoryVO>> queryCategoryPage(@RequestBody CommonRequest<CategoryQueryVO> commonRequest) {
        CategoryQueryVO categoryQueryVO = commonRequest.getBody();
        log.info(categoryQueryVO.toString());
        doBeforePagination(categoryQueryVO.getPageIndex(),categoryQueryVO.getPageSize(),categoryQueryVO.getOrderBy());
        CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
        PojoUtils.copyProperties(categoryQueryVO,categoryQueryDTO);
        List<CategoryDTO> categoryDTOS = categoryService.queryCategoryPage(categoryQueryDTO);
        List<CategoryVO> categoryVOS = new ArrayList<>();
        PojoUtils.copyProperties(categoryDTOS,categoryVOS);
        PageInfo<CategoryVO> pageInfo = new PageInfo<>(categoryVOS);
        return buildPageResponse(pageInfo);
    }

    @Override
    @ApiLog(msg = "树状获取题目类别")
    @ResponseBody
    public CommonResponse<List<CategoryTreeVO>> getCategoryTree(@RequestBody CommonRequest<CategoryQueryVO> commonRequest) {
        CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),categoryQueryDTO);
        List<CategoryTreeDTO> categoryTreeDTOList = categoryService.queryCategoryTree(categoryQueryDTO);
        log.info(categoryTreeDTOList.toString());
        List<CategoryTreeVO> categoryTreeVOList = PojoUtils.copyListProperties(categoryTreeDTOList,CategoryTreeVO::new);
        log.info(categoryTreeVOList.toString());
        for(CategoryTreeVO c : categoryTreeVOList){
            c.setLabel(c.getName());
            c.setValue(c.getId());
        }
        List<CategoryTreeVO> data = TreeUtil.getTreeList(0L,categoryTreeVOList);
        log.info(data.toString());
        return CommonResponseUtil.ok(SystemError.SUCCESS.getCode(),SystemError.SUCCESS.getMessage(),data);
    }

    @Override
    @ResponseBody
    public CommonResponse<CommonPage<CategoryVO>> getCategory(@RequestBody CommonRequest<CategoryIdsVO> commonRequest) {
        CategoryIdsDTO categoryIdListDTO = new CategoryIdsDTO();
        PojoUtils.copyProperties(commonRequest.getBody(),categoryIdListDTO);
        doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize(),commonRequest.getBody().getOrderBy());
        List<CategoryDTO> categoryDtoList = categoryService.queryByIdList(categoryIdListDTO);
        log.info(categoryDtoList.toString());
        List<CategoryVO> categoryVOS = PojoUtils.copyListProperties(categoryDtoList,CategoryVO::new);
        PageInfo<CategoryVO> pageInfo = new PageInfo<>(categoryVOS);
        return buildPageResponse(pageInfo);

    }
}
