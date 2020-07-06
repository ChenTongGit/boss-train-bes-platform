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
     * 当前页码
     */
    private Integer pageIndex;
    /**
     * 每页数据条数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer pageNum;
    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<T> rows;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
