package com.boss.xtrain.common.core.http;

import javax.validation.constraints.NotNull;

/**
 * @author ChenTong
 * @version 1.0
 * @description 分页请求
 * @date 2020/6/15 19:41
 * @modified
 **/
public class CommonPageRequest<T> {

    @NotNull
    private int pageNum;

    @NotNull
    private int pageSize;

    private T query;

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
