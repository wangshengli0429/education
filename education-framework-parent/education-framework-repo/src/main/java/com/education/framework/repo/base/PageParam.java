package com.education.framework.repo.base;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Yang Dong
 * @createTime 2017/7/20  10:59
 * @lastUpdater Yang Dong
 * @lastUpdateTime 2017/7/20  10:59
 * @note
 */
public class PageParam  implements Serializable{

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页数据量
     */
    private Integer pageSize;

    /**
     * 排序规则 enum SortTypeEnum
     */
    @Deprecated
    private Integer sortOrder;

    /**
     * 排序规则代码. group by 后面的sql
     *  例子 : "id asc, update_time desc"
     */
    private String orderBy;
    /**
     *  排序字段  表字段名字
     */
    private String sortColumn;
    /**
     * 排序方向
     */
    private String sortDirection;


    private Map<String,Integer> sortMap;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }


    public PageParam() {
    }

    public PageParam(Integer pageNum, Integer pageSize, Integer sortOrder) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.sortOrder = sortOrder;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    @Deprecated
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", sortOrder=" + sortOrder +
                ", orderBy='" + orderBy + '\'' +
                ", sortColumn='" + sortColumn + '\'' +
                ", sortDirection='" + sortDirection + '\'' +
                '}';
    }
}
