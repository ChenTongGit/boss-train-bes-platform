package com.boss.xtrain.common.core.http;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回结果
 * @author ChenTong
 * @description
 * @create 2020-07-04 08:46
 * @since
 */
public class CommonPage<T> implements Serializable {

    private static final long serialVersionUID = -347093683285644318L;
    /**
     *
     */
    private int pageNum;
    /**
     *
     */
    private int pageSize;
    /**
     *
     */
    private long totalSize;
    /**
     *
     */
    private int totalPages;

    /**
     * 分页内容
     */
    private List<?> content;

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

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }
}
