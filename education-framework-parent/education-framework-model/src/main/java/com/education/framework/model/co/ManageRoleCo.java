package com.education.framework.model.co;

import com.education.framework.model.po.ManageRole;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class ManageRoleCo extends ManageRole {


    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 当前页码数
     */
    private Integer pageNum;

    /**
     * 排序规则
     */
    private Integer sortOrder;

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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

}
