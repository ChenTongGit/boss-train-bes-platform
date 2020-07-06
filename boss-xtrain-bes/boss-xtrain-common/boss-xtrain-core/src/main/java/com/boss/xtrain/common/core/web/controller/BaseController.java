package com.boss.xtrain.common.core.web.controller;

import com.boss.xtrain.common.core.http.CommonResponse;
import com.github.pagehelper.page.PageMethod;

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
     * 分页
     * @param pageNum 分页总页数
     * @param pageSize 分页大小
     * @author ChenTong
     * @date 2020/7/4 7:57
     */
    protected void doPagination(int pageNum, int pageSize){
        PageMethod.startPage(pageNum, pageSize);
    }
}
