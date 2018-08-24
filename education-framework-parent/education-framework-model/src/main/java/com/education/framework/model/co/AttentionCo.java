package com.education.framework.model.co;

import com.education.framework.model.po.Attention;

/**
 * @author zhoulin
 * @createTime 2018/7/9.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/9.
 * @note 关注
 */
public class AttentionCo extends Attention {

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
