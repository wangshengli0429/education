package com.education.framework.common.pagination;

import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 2017/12/27 wangshengli
 * 分页
 */
public class Pagination<T> implements java.io.Serializable {

    private static final long serialVersionUID = -3192690360514204875L;

    private int itemCount = 0;

    private int pageCount = 0;

    private int pageNo = 0;

    private List<T> items = Collections.emptyList();

    public Pagination(int itemCount, int pageCount, int pageNo, List<T> items) {
        setItemCount(itemCount);
        setPageCount(pageCount);
        setPageNo(pageNo);
        setItems(items);
    }

    public Pagination() {
        //  nothing...
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
