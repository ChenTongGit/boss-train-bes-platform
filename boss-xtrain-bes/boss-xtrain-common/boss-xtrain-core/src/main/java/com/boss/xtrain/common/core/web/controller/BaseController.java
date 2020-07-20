package com.boss.xtrain.common.core.web.controller;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;

import java.util.List;

/**
 * MVC逻辑控制器基础抽象类，controller公共统一的方法
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/4 7:55
 * @copyright
 * @modified
 * @see
 * @since
 **/
public abstract class BaseController {

    /**
     *  分页前调用
     */
    protected Page<Object> doBeforePagination(int pageIndex, int pageSize, String orderBy){
        return PageMethod.startPage(pageIndex, pageSize, orderBy);
    }
    /**
     * 构造分页响应
     * @author ChenTong
     * @param pageInfo 
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.common.core.http.CommonPage<T>>
     * @date 2020/7/7 17:02
     */

    protected <T> CommonResponse<CommonPage<T>> buildPageResponse(Page<Object> pageInfo, List<T> list){
        CommonPage<T> pageResult = new CommonPage<>();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(list);
        return CommonResponseUtil.ok(pageResult);
    }
}
