package com.education.framework.model.co;

import com.education.framework.model.po.TeacherTime;

/**
 * Created by zhoulin on 2018/4/3.
 */
public class TeacherTimeCo extends TeacherTime {

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

    /**
     * 日期字符串
     */
    private String dateStr;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
